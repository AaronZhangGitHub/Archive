public class IPAddress {
	public static void main(String args[]) {
		System.out.println(binaryToDecimalIPAddress(args[0]));
	}

	private static String binaryToDecimalIPAddress(String binaryCommandLineArg) {
		StringBuffer decimalIPAddress = new StringBuffer();
		int firstIndex = 0;
		int lastIndex = 8;
		while(true) {
			decimalIPAddress.append(
					Integer.toString(eightDigitBinaryToDecimal(binaryCommandLineArg.substring(firstIndex, lastIndex))));
			firstIndex += 8;
			lastIndex += 8;
			if (firstIndex < 32) {
				decimalIPAddress.append('.');
			}else{
				break;
			}
		}
		return decimalIPAddress.toString();
	}

	private static int eightDigitBinaryToDecimal(String binaryRep) {
		return Integer.parseInt(binaryRep, 2);
	}
}
