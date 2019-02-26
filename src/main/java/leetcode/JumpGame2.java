package leetcode;

public class JumpGame2
{
	public int jump(int[] nums)
	{
		int i = 0;
		int jumpCount = 0;
		int endIndex = nums.length - 1;

		while (i < endIndex)
		{
			if (canIReachTheEnd(i + nums[i], endIndex))
				i = endIndex;
			else
				i = getMaxPotentialFromIndex(nums, i);
			jumpCount++;
		}

		return jumpCount;
	}

	private int getMaxPotentialFromIndex(int[] nums, int currentPos)
	{
		int maxReach = currentPos;
		int indexMaxPotential = currentPos;

		for (int jumpAmount = 0; jumpAmount <= nums[currentPos]; jumpAmount++)
		{
			int currentJumpPos = currentPos + jumpAmount;
			int potentialReachIndex = getPotentialReach(nums, currentJumpPos);
			if (potentialReachIndex > maxReach)
			{
				maxReach = potentialReachIndex;
				indexMaxPotential = currentJumpPos;
			}
		}
		currentPos = indexMaxPotential;
		return currentPos;
	}

	private int getPotentialReach(int[] nums, int pos)
	{
		return nums[pos] + pos;
	}

	private int getMaxPotentialIndexOnIndex(int[] nums, int i)
	{
		int maxReach = i;
		int indexMaxPotential = i;

		for (int potentialJumpAmount = 0;
			 potentialJumpAmount <= nums[i];
			 potentialJumpAmount++)
		{
			int potentialReachIndex = nums[i + potentialJumpAmount] + i + potentialJumpAmount;
			if (potentialReachIndex > maxReach)
			{
				maxReach = potentialReachIndex;
				indexMaxPotential = i + potentialJumpAmount;
			}
		}
		i = indexMaxPotential;
		return i;
	}

	private boolean canIReachTheEnd(int index, int endIndex)
	{
		return index >= endIndex;
	}
}
