package spaghetti;
//Can str be a palindrome if you remove k chars
public class KPalindrome {

	private boolean result;

	public boolean getResult(String str, int k){
		assert (k >= 0) && (null != str) && (str.length() != 0): "Invalid input";

		char[] chars = str.toCharArray();
		result = false;
		checkIfCanBePalindrome(chars, k, 0, chars.length - 1);
		return result;
	}

	private void checkIfCanBePalindrome(char[] chars, int k, int i, int j){

		if (k >= 0) {
			if (i < j) {

				if (chars[i] == chars[j]) {
					checkIfCanBePalindrome(chars, k, i + 1, j - 1);
				} else {
					checkIfCanBePalindrome(chars, k - 1, i + 1, j);
					checkIfCanBePalindrome(chars, k - 1, i, j - 1);
				}
			} else
				if (k == 0)
					result = true;
		}
	}
}
