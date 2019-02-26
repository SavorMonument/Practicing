package leetcode;

public class ReverseInteger
{
	public int reverse(int x)
	{
		int number = 0;

		while (x != 0)
		{
			number = (number * 10) + (x % 10);
			x /= 10;

			if (x != 0 && (number > Integer.MAX_VALUE / 10 || number < Integer.MIN_VALUE / 10))
				return 0;
		}
		return number;
	}

	private int getStub(int x)
	{
		int stub = 1;
		x /= 10;

		while (x != 0)
		{
			x /= 10;
			stub *= 10;
		}
		return stub;
	}

	private int godDammit(int digitNum)
	{
		int result = 1;
		for (int i = 0; i < digitNum - 1; i++)
		{
			result *= 10;
		}

		return result;
	}

	private int getDigitNum(int x)
	{
		int count = 0;

		while (x != 0)
		{
			x /= 10;
			count++;
		}
		return count;
	}
}
