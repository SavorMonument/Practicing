package spaghetti;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Given an input string "aabbccba", find the shortest substring from the alphabet "abc".
//In the above example, there are these substrings "aabbc", "aabbcc", "ccba" and "cba".
//However the shortest substring that contains all the characters in the alphabet is "cba",
// so "cba" must be the output.
//Output doesnt need to maintain the ordering as in the alphabet.
//Other examples:
//input = "abbcac", alphabet="abc" Output : shortest substring = "bca".
public class ShortestAlphabetSubString {

	//Is this more efficient? too lazy to check
	public String getResult(String str, String alphabet) {

		Map<Character, Integer> alphaChars = new HashMap<>();
		fillCharsFromAlphabetWithZero(alphaChars, alphabet);

		StringBuffer subStr = new StringBuffer();
		String minSub = "";

		for (char currentChar : str.toCharArray()) {

			subStr.append(currentChar);
			alphaChars.put(currentChar, alphaChars.get(currentChar) + 1);

			//If the char on the first position of the sub sequence if found more than once
			while (alphaChars.get(subStr.charAt(0)) > 1) {

				//trim the first char from sub sequence and decrement it's count in the map
				char firstCharInSub = subStr.charAt(0);
				alphaChars.put(firstCharInSub, alphaChars.get(firstCharInSub) - 1);
				subStr = new StringBuffer(subStr.subSequence(1, subStr.length()));
			}
			//If the sub sequence contains all the chars in alphabet
			if (hasAtLeastOneOfEach(alphaChars)) {
				//if it's the first sequence found with all the alpha chars
				if (minSub.equals(""))
					minSub = subStr.toString();
				//Check if the sub sequence is smaller that the previous smallest
				else if (minSub.length() > subStr.length())
					minSub = subStr.toString();
			}
		}

		return minSub;
	}

	private boolean hasAtLeastOneOfEach(Map<Character, Integer> alphaChars) {

		for(Integer i: alphaChars.values()){
			if (i == 0)
				return false;
		}
		return true;
	}

	private void fillCharsFromAlphabetWithZero(Map<Character, Integer> alphaChars, String alphabet) {

		for (char c : alphabet.toCharArray()) {

			alphaChars.put(c, 0);
		}
	}

	//n^2 solution
	public String getInneficientResult(String str, String alphabet) {

		Set<Character> alphaChars = new HashSet<>();
		fillCharsFromAlphabetWithZero(alphaChars, alphabet);
		String smallestSub = "";

		for (int i = 0; i < str.length(); i++) {

			String currentSub = checkSmallestStraightString(str.substring(i), new HashSet<Character>(alphaChars));

			if (null != currentSub) {
				if (smallestSub.equals(""))
					smallestSub = currentSub;
				else if (currentSub.length() < smallestSub.length()) {
					smallestSub = currentSub;
				}
			}
		}
		return smallestSub;
	}

	//Just iterates from 0 until find all alpha chars
	private String checkSmallestStraightString(String str, Set<Character> alphaChars) {

		int index = 0;

		while (alphaChars.size() > 0 && index < str.length()) {

			char currChar = str.charAt(index);
			alphaChars.remove(currChar);
			index++;
		}

		if (alphaChars.size() == 0)
			return str.substring(0, index);
		else
			return null;
	}

	private void fillCharsFromAlphabetWithZero(Set<Character> chars, String alphabet) {

		for (char c : alphabet.toCharArray()) {

			chars.add(c);
		}
	}
}
