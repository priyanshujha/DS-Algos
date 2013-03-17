package Miscellaneous;
public class StringPermutation {
	public static void main(String[] arg) {
		String input = "priyanshu";
		int inputLength = input.length();
		boolean[] used = new boolean[inputLength];
		StringBuffer outputString = new StringBuffer();
		char[] in = input.toCharArray();
		doPermute(in, outputString, used, inputLength, 0);

	}

	static void doPermute(char[] in, StringBuffer outputString, boolean[] used,
			int inputlength, int level) {
		if (level == inputlength) {
			System.out.println(outputString.toString());
			return;
		}

		for (int i = 0; i < inputlength; ++i) {

			if (used[i])
				continue;

			outputString.append(in[i]);
			used[i] = true;
			doPermute(in, outputString, used, inputlength, level + 1);
			used[i] = false;
			outputString.setLength(outputString.length() - 1);
		}
	}
}
