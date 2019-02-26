package leetcode;

public class ValidNumber
{
	private int stringindex;

	public boolean isNumber(String s)
	{
		stringindex = 0;
		skipWhiteSpace(s);
		skipSingIfExists(s);

		if (!checkDecimalNumber(s))
			return false;

		if (stringindex < s.length() && s.charAt(stringindex) == 'e')
		{
			stringindex++;
			skipSingIfExists(s);
			if (!existsInteger(s))
				return false;
			else skipIntegerIfAny(s);
		}

		skipWhiteSpace(s);

		return stringindex == s.length();
	}

	// Checks if there exists a decimal number ex: 0.1, .1, 1. - all valid apparently, and skips it
	private boolean checkDecimalNumber(String s)
	{
		boolean gotNumber = existsInteger(s);
		skipIntegerIfAny(s);

		if (stringindex < s.length() && s.charAt(stringindex) == '.')
			stringindex++;

		if (!gotNumber && !existsInteger(s))
			return false;
		skipIntegerIfAny(s);

		return true;
	}

	private boolean existsInteger(String s)
	{
		return !(stringindex >= s.length() || !Character.isDigit(s.charAt(stringindex)));
	}

	private void skipIntegerIfAny(String s)
	{
		while (stringindex < s.length() && Character.isDigit(s.charAt(stringindex)))
			stringindex++;
	}

	private void skipSingIfExists(String s)
	{
		if (stringindex < s.length() && (s.charAt(stringindex) == '-' || s.charAt(stringindex) == '+'))
			stringindex++;
	}

	private void skipWhiteSpace(String s)
	{
		while (stringindex < s.length() && Character.isWhitespace(s.charAt(stringindex)))
			stringindex++;
	}
}
