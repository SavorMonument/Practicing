package leetcode;

import java.util.regex.Pattern;

public class Division
{

	public int divide(int dividend, int divisor) {

		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;

		boolean isNegative = (dividend ^ divisor) < 0;
		dividend = dividend > 0 ? -dividend : dividend;
		divisor = divisor > 0 ? -divisor : divisor;

		int count = 0;

		while(divisor >= dividend)
		{
			long temp = divisor;
			int tempCount = 1;
			while((temp << 1) >= dividend)
			{
				temp <<= 1;
				tempCount <<= 1;
			}

			dividend -= temp;
			count += tempCount;
		}


		if (isNegative)
			return -count;
		else
			return count;
	}

	public int divide2(int dividend, int divisor) {

		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;

		boolean isNegative = (dividend ^ divisor) < 0;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		int currentNumber = dividend;
		int count = 0;

		while(currentNumber - divisor >= 0)
		{
			currentNumber -= divisor;
			count++;
		}

		if (isNegative)
			return -count;
		else
			return count;
	}

	public int divide1(int dividend, int divisor) {

		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;

		int currentNumber = 0;
		int count = 0;

		boolean isNegative = (dividend ^ divisor) < 0;
		dividend = dividend > 0 ? -dividend : dividend;
		divisor = divisor > 0 ? -divisor : divisor;

		int maxValue = Integer.MIN_VALUE - divisor;
		while(currentNumber >= maxValue && currentNumber + divisor >= dividend)
		{
			currentNumber += divisor;
			count++;
		}

		if (isNegative)
			return -count;
		else
			return count;
	}
}
