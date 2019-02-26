package leetcode;

import java.util.*;

public class SubstringConcatOfWords
{
	public List<Integer> findSubstring(String s, String[] words) {

		List<Integer> resultIndexes = new LinkedList<>();
		if (s.equals("") || words.length == 0)
			return resultIndexes;

		int wordLength = words[0].length();

		for (int i = 0; i < (s.length() - (wordLength * words.length)) + 1; i++)
		{
			int index = i;
			List<String> wordSet = new LinkedList<>(Arrays.asList(words));
			while((index + wordLength - 1) < s.length() &&
					wordSet.remove(s.substring(index, index + wordLength)))
			{
				index += wordLength;
			}

			if (wordSet.size() == 0)
				resultIndexes.add(i);
		}

		return resultIndexes;
	}



}
