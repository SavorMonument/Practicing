package spaghetti;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Given a string, find the longest substring that contains only two unique characters.
//For example, given "abcbbbbcccbdddadacb", the longest substring that contains
//2 unique character is "bcbbbbcccb".
public class StringLongestSequence {

	String str;

	public StringLongestSequence(String str) {

		this.str = str;
	}

	public String getResult() {
		assert (null != str) && (str.length() > 1) : "Invalid str";

		char[] chars = str.toCharArray();
		String sequence = "";

		for (int i = 0; i < chars.length - 1; i++) {

			String currentSeq = findBiggestStraightSeq(Arrays.copyOfRange(chars, i, chars.length), 2);

			if (currentSeq.length() > sequence.length()) {
				sequence = currentSeq;
			}
		}

		return sequence;
	}

	private String findBiggestStraightSeq(char[] chars, int uniqueCharCount) {
		assert (chars.length > 1) : "Array too small";

		Set<Character> uniqueChars = new HashSet<>();
		int index = 0;

		while (index < chars.length && uniqueChars.size() <= uniqueCharCount) {

			uniqueChars.add(chars[index]);
			index++;
		}


		return new String(chars, 0, index - 1);
	}


}