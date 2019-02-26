package leetcode;

import java.util.Arrays;

public class NextPermutation
{
	public int[] nextPermutation(int[] nums)
	{
		boolean swapped = false;
		for (int i = nums.length - 1; !swapped && i > 0; i--)
		{
			if (nums[i] > nums[i - 1])
			{
				swap(nums, i, i - 1);
				swapped = true;
			}
		}

		if (!swapped)
			for (int i = 0; i < nums.length / 2; i++)
			{
				swap(nums, i, nums.length - i - 1);
			}

		return nums;
	}

	private void swap(int[] nums, int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
