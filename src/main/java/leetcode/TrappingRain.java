package leetcode;

public class TrappingRain
{
	public int trap(int[] height)
	{

		int waterTrapped = 0;

		for (int i = 0; i < height.length - 2; )
		{
			int rightPillar = findRightPillar(height, i);
			waterTrapped += calculateWatterTrappedBetweenPillars(height, i, rightPillar);
			i = rightPillar;
		}

		return waterTrapped;
	}

	private int calculateWatterTrappedBetweenPillars(int[] height, int leftPillar, int rightPillar)
	{
		if (pillarsNextToEachOther(leftPillar, rightPillar))
			return 0;

		int watterTrapped = 0;
		int smallerPillar = Math.min(height[leftPillar], height[rightPillar]);
		for (int i = leftPillar + 1; i < rightPillar; i++)
		{
			watterTrapped += smallerPillar - height[i];
		}

		return watterTrapped;
	}

	private boolean pillarsNextToEachOther(int leftPillar, int rightPillar)
	{
		return leftPillar + 1 == rightPillar;
	}

	//Find next height at least as big as leftPillar or biggest one if none exist
	public int findRightPillar(int[] height, int leftPillar)
	{
		assert leftPillar + 2 < height.length : "Need at least 3 pillars in order to trap water";

		int rightPillar = leftPillar + 1;

		int max = height[rightPillar];
		int maxIndex = rightPillar;

		while (rightPillar < height.length && height[rightPillar] < height[leftPillar])
		{
			if (height[rightPillar] > max)
			{
				max = height[rightPillar];
				maxIndex = rightPillar;
			}

			rightPillar++;
		}
		if (rightPillar == height.length)
			return maxIndex;
		else
			return rightPillar;
	}
}
