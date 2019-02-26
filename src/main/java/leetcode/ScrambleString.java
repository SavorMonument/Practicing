package leetcode;

import java.util.HashMap;

public class ScrambleString
{
	public boolean isScramble(String s1, String s2)
	{
		if (s1.equals(s2))
			return true;
		else if (!isAnagram(s1, s2))
			return false;
		else
			return checkScrambled(s1, s2);
	}

	private boolean checkScrambled(String s1, String s2)
	{
		assert s1.length() == s2.length();

		if (s1.equals(s2))
			return true;

		if (!isAnagram(s1, s2))
			return false;

		for (int splitPoint = 1; splitPoint < s1.length(); splitPoint++)
		{
			if (checkScrambled(s1.substring(0, splitPoint), s2.substring(0, splitPoint)) &&
					checkScrambled(s1.substring(splitPoint), s2.substring(splitPoint)))
				return true;

			if (checkScrambled(s1.substring(0, splitPoint), s2.substring(s2.length() - splitPoint)) &&
					checkScrambled(s1.substring(splitPoint), s2.substring(0, s2.length() - splitPoint)))
				return true;
		}
		return false;
	}

	private String reverseOnIndex(String s2, int splitPoint)
	{
		return s2.substring(splitPoint) + s2.substring(0, splitPoint);
	}

	private boolean areHalvesAnagrams(String s1, String s2, int splitPoint)
	{
		return isAnagram(s1.substring(0, splitPoint), s2.substring(0, splitPoint)) &&
				isAnagram(s1.substring(splitPoint), s2.substring(splitPoint));
	}

	public boolean isAnagram(String s1, String s2)
	{
		if (s1.length() != s2.length())
			return false;

		HashMap<Character, Integer> charsContained = new HashMap<>();

		for (char c : s2.toCharArray())
			charsContained.put(c, charsContained.get(c) == null ? 1 : charsContained.get(c) + 1);

		for (char c : s1.toCharArray())
		{
			Integer charOccurrence = charsContained.get(c);
			if (charOccurrence == null)
				return false;
			else if (charOccurrence == 1)
				charsContained.remove(c);
			else
				charsContained.put(c, charsContained.get(c) - 1);
		}

		return charsContained.size() == 0;
	}
}
