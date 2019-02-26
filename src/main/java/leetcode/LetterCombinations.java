package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations
{
	private String[] keyMappings = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits)
	{
		if (digits.length() == 0)
			return new ArrayList<>();
		int[] keysPressed = getAsDigitArray(digits);

		return doIt(keysPressed);
	}

	private int[] getAsDigitArray(String digits)
	{
		int[] digitArray = new int[digits.length()];

		for (int i = 0; i < digitArray.length; i++)
			digitArray[i] = Character.getNumericValue(digits.charAt(i));

		return digitArray;
	}

	private List<String> doIt(int[] keys)
	{
		List<String> resultStrings = new LinkedList<>();
		String[] strings = getMappingsForFields(keys);

		int i = 0;
		while(i != -1)
		{
			resultStrings.add(constructFirstCharsString(strings));

			i = strings.length - 1;
			while(i >= 0)
			{
				if (strings[i].length() > 1)
				{
					strings[i] = strings[i].substring(1);
					break;
				}
				strings[i] = keyMappings[keys[i]];
				i--;
			}
		}

		return resultStrings;
	}

	private String[] getMappingsForFields(int... fields)
	{
		String[] chars = new String[fields.length];

		for (int i = 0; i < fields.length; i++)
		{
			chars[i] = keyMappings[fields[i]];
		}

		return chars;
	}

	private String constructFirstCharsString(String[] strings)
	{
		StringBuilder currentString = new StringBuilder();

		for (int i = 0; i < strings.length; i++)
			currentString.append(strings[i].charAt(0));

		return currentString.toString();
	}
}
