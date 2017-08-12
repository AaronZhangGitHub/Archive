
/*
 Name: Aaron Zhang
 Matric: A0164324L
 Is this a group submission (yes/no)?
 No
 */

import java.net.*;
import java.nio.ByteBuffer;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class WebServer {
    public static void main(String[] args) {
        // dummy value that is overwritten below
        int port = 8000;
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Usage: java webserver <port>");
            System.exit(0);
        }
        
        WebServer serverInstance = new WebServer();
        try {
            serverInstance.start(port);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private void start(int port) throws IOException {
        System.out.println("Starting server on port " + port);
        ServerSocket ss;
        ss = new ServerSocket(port);
        while (true) {
            Socket clientSocket = ss.accept();
            BufferedReader clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedOutputStream outputToSocket = new BufferedOutputStream(clientSocket.getOutputStream());
            handleClientSocket(clientSocket, clientInput, outputToSocket);
        }
    }
    
    /**
     * Handles requests sent by a client
     *
     * @param client
     *            Socket that handles the client connection
     * @throws IOException
     */
    
    private void handleClientSocket(Socket client, BufferedReader clientInput, BufferedOutputStream outputToSocket)
    throws IOException {
        HttpRequest httpRequest = new HttpRequest(clientInput);
        if (httpRequest.parseRequest()) {
            httpRequest.printFullRequest();
            byte[] response = formHttpResponse(httpRequest);
            sendHttpResponse(client, response, clientInput, outputToSocket, httpRequest.getHttpVersion());
        } else {
            // can not parse request, meaning at the end
            client.close();
            clientInput.close();
            outputToSocket.close();
        }
    }
    
    /**
     * Sends a response back to the client
     *
     * @param client
     *            Socket that handles the client connection
     * @param response
     *            the response that should be send to the client
     * @throws IOException
     */
    private void sendHttpResponse(Socket client, byte[] response, BufferedReader clientInput, BufferedOutputStream bos, String httpVersion) throws IOException {
        bos.write(response);
        bos.flush();
        if (httpVersion.equals("HTTP/1.0")) {
            bos.close();
            client.close();
            clientInput.close();
        } else {
            handleClientSocket(client, clientInput, bos);
        }
    }
    
    /**
     * Form a response to an HttpRequest
     *
     * @param request
     *            the HTTP request
     * @return a byte[] that contains the data that should be send to the client
     */
    private byte[] formHttpResponse(HttpRequest request) {
        File requestedFile = getFile(request);
        byte httpResponseArray[] = null;
        if (requestedFile.exists() && !requestedFile.isDirectory()) {
            try {
                // File found
                httpResponseArray = concatenate(formHTTPResponseNoData(request, "200 OK", requestedFile),
                                                getReadFileByteArray(requestedFile));
            } catch (IOException e) {
                System.out.println("Could not read file from " + requestedFile.getName());
                e.printStackTrace();
            }
        } else {
            // File not found
            httpResponseArray = concatenate(formHTTPResponseNoData(request, "404 Not Found", requestedFile),
                                            form404Response(request));
        }
        return httpResponseArray;
    }
    
    private File getFile(HttpRequest request) {
        String relativePath = System.getProperty("user.dir");
        String pathOfFile = relativePath + request.getFilePath();
        File f = new File(pathOfFile);
        return f;
    }
    
    private byte[] formHTTPResponseNoData(HttpRequest request, String status, File f) {
        StringBuffer sb = new StringBuffer();
        sb.append(request.getHttpVersion());
        sb.append(' ');
        sb.append(status);
        sb.append("\r\n");
        sb.append("Content-Length: ");
        sb.append(f.length());
        sb.append("\r\n\r\n");
        return sb.toString().getBytes();
    }
    
    private static byte[] getReadFileByteArray(File f) throws IOException {
        byte[] buffer = new byte[(int) f.length()];
        FileInputStream fis = new FileInputStream(f);
        BufferedInputStream bis = new BufferedInputStream(fis);
        bis.read(buffer);
        bis.close();
        return buffer;
    }
    
    /**
     * Form a 404 response for a HttpRequest
     *
     * @param request
     *            a HTTP request
     * @return a byte[] that contains the data that should be send to the client
     */
    private byte[] form404Response(HttpRequest request) {
        String response = get404Content(request.getFilePath());
        byte[] responseByteArray = response.getBytes();
        return responseByteArray;
    }
    
    /**
     * Concatenates 2 byte[] into a single byte[] This is a function provided
     * for your convencience.
     *
     * @param buffer1
     *            a byte array
     * @param buffer2
     *            another byte array
     * @return concatenation of the 2 buffers
     */
    private byte[] concatenate(byte[] buffer1, byte[] buffer2) {
        byte[] returnBuffer = new byte[buffer1.length + buffer2.length];
        System.arraycopy(buffer1, 0, returnBuffer, 0, buffer1.length);
        System.arraycopy(buffer2, 0, returnBuffer, buffer1.length, buffer2.length);
        return returnBuffer;
    }
    
    /**
     * Returns a string that represents a 404 error You should use this string
     * as the return website for 404 errors.
     *
     * @param filePath
     *            path of the file that caused the 404
     * @return a String that represents a 404 error website
     */
    private String get404Content(String filePath) {
        // You should not change this function. Use it as it is.
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>");
        sb.append("404 Not Found");
        sb.append("</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h1>404 Not Found</h1> ");
        sb.append("<p>The requested URL <i>" + filePath + "</i> was not found on this server.</p>");
        sb.append("</body>");
        sb.append("</html>");
        
        return sb.toString();
    }
}

class HttpRequest {
    // NEEDS IMPLEMENTATION
    // This class should represent a HTTP request.
    // Feel free to add more attributes if needed.
    
    private List<String> httpInputList = new ArrayList<String>();
    private String filePath;
    private String httpVersion;
    private BufferedReader inputRequest;
    private boolean requestStored;
    
    public HttpRequest(BufferedReader inputRequest) {
        this.inputRequest = inputRequest;
        this.requestStored = false;
    }
    
    String getFilePath() {
        return filePath;
    }
    // NEEDS IMPLEMENTATION
    // If you add more private variables, add you getter methods here
    
    public void storeRequest() throws IOException {
        requestStored = true;
        String s = inputRequest.readLine();
        if (s != null) {
            System.out.println(s);
            while (s.length() != 0) {
                httpInputList.add(s);
                s = inputRequest.readLine();
            }
        }
    }
    
    public String getFullRequest() throws IOException {
        StringBuffer sb = new StringBuffer();
        for (String s : httpInputList) {
            sb.append(s);
        }
        return sb.toString();
    }
    
    public void printFullRequest() throws IOException {
        for (String s : httpInputList) {
            System.out.println(s);
        }
    }
    
    public String getHttpVersion() {
        return httpVersion;
    }
    
    /**
     * Parses a request and set all the private variables
     * 
     * @param request
     *            a string that was read from the socket and contains the
     *            request
     * @return returns true if parsing was successful
     * @throws IOException
     */
    public boolean parseRequest() throws IOException {
        if (!requestStored) {
            this.storeRequest();
        }
        if (httpInputList.size() > 0) {
            String requestLine = httpInputList.get(0);
            requestLine = requestLine.replaceAll("\r\n", "");
            String[] splitRequestLine = requestLine.split("\\s+");
            this.filePath = splitRequestLine[1];
            this.httpVersion = splitRequestLine[2];
            return true;
        }
        return false;
    }
}
