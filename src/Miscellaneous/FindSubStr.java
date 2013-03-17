package Miscellaneous;

public class FindSubStr {

	public static int[] prekmp(String pattern) {
		int[] next = new int[pattern.length()];
		int i = 0, j = -1;
		next[0] = -1;
		while (i < pattern.length() - 1) {
			while (j >= 0 && pattern.charAt(i) != pattern.charAt(j))
				j = next[j];
			i++;
			j++;
			System.out.println(i+" "+j);
			next[i] = j;
		}
		return next;
	}

	public static int kmp(String text, String pattern) {
		int[] next = prekmp(pattern);
		int i = 0, j = 0;
		while (i < text.length()) {
			while (j >= 0 && text.charAt(i) != pattern.charAt(j))
				j = next[j];
			i++;
			j++;			
			if (j == pattern.length())
				return i - pattern.length();
		}
		return -1;
	}

	public static void main(String args[]) {
		String S = "ABC ABCDAB ABCDABCDABDE";
		String W = "ABCDABD";
		System.out.println(kmp(S, W));
	}

}