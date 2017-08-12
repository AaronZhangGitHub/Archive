/*
Name: YOUR_NAME_HERE
Matric: YOUR_MATRIC_HERE
*/



public class Alice {
    public static void main(String[] args) {
        int N = 0;
        String fileToSend = null;
        int port = 0;
        String filenameAtBob = null;
        try {
          N = Integer.parseInt(args[0]);
          fileToSend = args[1];
          port = Integer.parseInt(args[2]);
          filenameAtBob = args[3];
        } catch (Exception e) {
          System.out.println("Usage: java Alice <N> <path/filename> <unreliNetPort> <rcvFileName>");
          System.exit(0);
        }
      
    }
}