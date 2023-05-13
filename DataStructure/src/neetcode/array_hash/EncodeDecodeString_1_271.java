package neetcode.array_hash;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString_1_271 {

	public static final char DELIMITER = '#';

	public static void main(String[] args) {
		ArrayList<String> input = new ArrayList<>();
		input.add("Hello");
		input.add("word");
		input.add(" ");

		System.out.println(input);

		EncodeDecodeString_1_271 encodeDecodeString = new EncodeDecodeString_1_271();

		String str = encodeDecodeString.encode(input);
		System.out.println(str);

		List<String> strs = encodeDecodeString.decode(str);
		System.out.println(strs);
	}

	private String encode(ArrayList<String> inputStrs) {
		StringBuilder sb = new StringBuilder();
		for (String str : inputStrs) {
			sb.append(str.length());
			sb.append(DELIMITER);
			sb.append(str);
		}
		return sb.toString();
	}

	private List<String> decode(String str) {
		ArrayList<String> strs = new ArrayList<String>();
		char[] charArray = str.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			StringBuilder sb = new StringBuilder();
			while (charArray[i] != DELIMITER) {
				sb.append(charArray[i++]);
			}
			i++;

			int numOfChars = Integer.valueOf(sb.toString());
			int end = i + numOfChars;

			sb = new StringBuilder();
			while (i < end) {
				sb.append(charArray[i++]);
			}
			i--;
			strs.add(sb.toString());
		}
		return strs;
	}
}
