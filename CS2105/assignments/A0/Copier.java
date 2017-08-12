import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copier {
	public static void main(String args[]) throws IOException {
		//copyExistingFile("src/assignment0/doge.jpg","src/assignment0/doge.jpg");
		//System.out.println(getFileSize("src/assignment0/doge.jpg"));
		copyExistingFile(args[0],args[1]);
	}

	private static byte[] getReadFileByteArray(String filePath, long fileLength) throws IOException {
		byte[] buffer = new byte[(int)fileLength];
		FileInputStream fis = new FileInputStream(filePath);
		BufferedInputStream bis = new BufferedInputStream(fis);
		bis.read(buffer);
		bis.close();
		return buffer;
	}

	private static void writeFile(byte[] sourceFileArray, String destinationPath) {
		try {
			FileOutputStream fos = new FileOutputStream(destinationPath);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bos.write(sourceFileArray);
			bos.close();
		} catch (IOException e) {
			System.out.println("IO Exception error");
			e.printStackTrace();
		}
	}

	private static void copyExistingFile(String sourcePath, String destinationPath) {
			byte[] buffer;
			try {
				buffer = getReadFileByteArray(sourcePath, getFileSize(sourcePath));
				writeFile(buffer, destinationPath);
				System.out.println(sourcePath + " is successfully copied to " + destinationPath);
			} catch (IOException e) {
				System.out.println("IO Exception error");
				e.printStackTrace();
			}
	}
	private static long getFileSize(String filePath){
		File f = new File(filePath);
		return f.length();
	}
	private static boolean compareFileSize(String sourcePath, String destinationPath) {
		File sourceFile = new File(sourcePath);
		File destinationFile = new File(destinationPath);
		long sourceFileLength = sourceFile.length();
		long destinationFileLength = destinationFile.length();
		if (sourceFileLength == destinationFileLength) {
			return true;
		}
		return false;
	}

}
