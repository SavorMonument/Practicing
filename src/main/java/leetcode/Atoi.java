package leetcode;

public class Atoi
{
	public int myAtoi(String str)
	{
		int strLength = str.length();
		int result = 0;
		int sign = 1;
		int index = 0;

		while (hasMoreCharacters(index, strLength) && isWhiteSpaceChar(str.charAt(index)))
			index++;

		if (hasMoreCharacters(index, strLength) && isPositiveSign(str.charAt(index)))
			index++;
		else if (hasMoreCharacters(index, strLength) && isNegativeSign(str.charAt(index)))
		{
			sign = -1;
			index++;
		}
		int digitIndex = 0;
		while (hasMoreCharacters(index, strLength) && Character.isDigit(str.charAt(index)))
		{
			result = (result * 10) + (str.charAt(index) - 48);
			digitIndex++;
			index++;

			if (digitIndex > 8 && hasMoreCharacters(index, strLength) && Character.isDigit(str.charAt(index)))
			{
				if (!checkNumberWithinInteger(result) ||
						!checkDigitAdditionValid(result, str.charAt(index) - 48, sign))
					if (sign < 0)
						return Integer.MIN_VALUE;
					else
						return Integer.MAX_VALUE;
			}
		}

		return result * sign;
	}

	private boolean checkNumberWithinInteger(int result)
	{
		if (result > Integer.MAX_VALUE / 10)
			return false;

		return true;
	}

	private boolean checkDigitAdditionValid(int number, int digit, int sign)
	{
		if (number == Integer.MAX_VALUE / 10)
			if (sign < 0)
				return digit <= 8;
			else return digit <= 7;

		return true;
	}

	private boolean isNegativeSign(char c)
	{
		return c == '-';
	}

	private boolean isPositiveSign(int c)
	{
		return c == '+';
	}

	private boolean isWhiteSpaceChar(int c)
	{
		return c == ' ';
	}

	private boolean hasMoreCharacters(int index, int length)
	{
		return index < length;
	}
}
