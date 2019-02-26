package leetcode;

public class MostWater
{
	public int maxArea(int[] height) {

		int maxArea = 0;
		for (int i = 0; i < height.length - 1; i++)
		{
			for (int j = i + 1; j < height.length; j++)
			{
				int newArea = Math.min(height[i], height[j]) * (j - i);
				if (newArea > maxArea)
					maxArea = newArea;
			}
		}

		return maxArea;
	}

	private Entry[] parseEntries(int[] heights)
	{
		Entry[] entries = new Entry[heights.length];

		for (int i = 0; i < heights.length; i++)
		{
			entries[i] = new Entry(heights[i], i);
		}

		return entries;
	}

	class Entry
	{
		int value;
		int position;

		public Entry(int value, int position)
		{
			this.value = value;
			this.position = position;
		}
	}
}
