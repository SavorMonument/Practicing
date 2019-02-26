package leetcode;

public class RExpressionMatching
{
	public boolean isMatch(String s, String p)
	{
		return match(s, s.length() - 1, p, p.length() - 1);
	}

	private boolean match(String str, int strIndex, String pattern, int patternIndex)
	{
		if (strIndex == -1 && patternIndex == -1)
			return true;
		if ((strIndex == -1 && pattern.charAt(patternIndex) != '*') || patternIndex == -1)
			return false;

		if (pattern.charAt(patternIndex) == '*')
		{
			patternIndex--;
			if (pattern.charAt(patternIndex) == '.')
				return true;

			//match without the * character
			if (match(str, strIndex, pattern, patternIndex - 1))
				return true;

			//progressively remove chars from the str that match the * char and call match on it
			while (strIndex > -1 &&
					areCharsMatching(str.charAt(strIndex), pattern.charAt(patternIndex)))
			{
				if (match(str, strIndex, pattern, patternIndex))
					return true;
				strIndex--;
			}
		} else if (areCharsMatching(str.charAt(strIndex), pattern.charAt(patternIndex)))
		{
			return match(str, strIndex - 1, pattern, patternIndex - 1);
		}
		return false;
	}

	public boolean areCharsMatching(char strChar, char patternChar)
	{
		return patternChar == '.' || strChar == patternChar;
	}
}
