import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.CRC32;

public class Checksum {
	public static void main(String args[]){
		printCheckSumOfFile(args[0]);
	}
	private static byte[] getByteArrayOfFile(String filename){
		byte[] bytes = null;
		try {
			bytes = Files.readAllBytes(Paths.get(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytes;
	}
	private static void printCheckSumOfFile(String filename){
		CRC32 crc = new CRC32();
		crc.update(getByteArrayOfFile(filename));
		System.out.println(crc.getValue());
	}
}
