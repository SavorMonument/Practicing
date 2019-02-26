package leetcode;

public class ZigZag
{
	public String convert(String s, int numRows) {
		int increment = (numRows - 1) * 2;
		int index = 0;
		int done = s.length();
		int currentRow = 1;
		boolean goingUp = false;

		StringBuilder result = new StringBuilder();

		while(done > 0)
		{
			result.append(s.charAt(index));

			if (currentRow == 1)
				goingUp = false;
			else if (currentRow == numRows)
				goingUp = true;
			else
				goingUp = !goingUp;

			if (index + increment >= s.length())
			{
				currentRow++;
				index--;
			}

			index += increment;
			if (index >= s.length())
				index -= s.length();

			if (goingUp )
				increment = (currentRow - 1) * 2;
			else
				increment = (numRows - currentRow) * 2;

			done--;
		}

		return result.toString();
	}
}
