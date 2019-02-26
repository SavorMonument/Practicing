package leetcode;

public class LongestPalindromicSubstring
{
	public String longestPalindrome(String s)
	{
		String biggestPalindrome = "";
		for(int i = 0; i < s.length(); i++)
		{
			String temp = getBiggestPalindromeOnIndex(s, i);

			if (temp.length() > biggestPalindrome.length())
				biggestPalindrome = temp;
		}

		return biggestPalindrome;
	}

	private String getBiggestPalindromeOnIndex(String str, int index)
	{
		assert index >= 0 && index < str.length();

		if (str.length() == 1 || index == str.length() - 1)
			return str.substring(index, index + 1);

		String odd = "";
		String even = "";

		if (index > 0 && index < str.length() - 1)
			odd = getBiggestOddPalindromeOnIndex(str, index);
		if (index < str.length() - 1)
			even = getBiggestEvenPalindromeOnIndex(str, index);

		return odd.length() > even.length() ? odd : even;
	}

	private String getBiggestOddPalindromeOnIndex(String str, int index)
	{
		int i = index;
		int j = index;

		while (((i > 0) && (j < (str.length() - 1))) && (str.charAt(i - 1) == str.charAt(j + 1)))
		{
			i--;
			j++;
		}
		return str.substring(i, j + 1);
	}

	private String getBiggestEvenPalindromeOnIndex(String str, int index)
	{
		int i = index;
		int j = index + 1;

		if (str.charAt(i) != str.charAt(j))
			return "";

		while (((i > 0) && (j < (str.length() - 1))) && (str.charAt(i - 1) == str.charAt(j + 1)))
		{
			i--;
			j++;
		}
		return str.substring(i, j + 1);
	}
}
