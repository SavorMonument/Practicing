package leetcode;

public class MedianOfSortedArrays
{
	private int firstIndex = -1;
	private int secondIndex = -1;

	public double findMedianSortedArrays(int[] nums1, int[] nums2)
	{

		int totalLength = nums1.length + nums2.length;
		int middle = (totalLength - 1) / 2;

		while (firstIndex + secondIndex + 2 < middle)
		{
			advanceAndGet(nums1, nums2);
		}

		double result;
		if (totalLength % 2 == 0)
			result = (advanceAndGet(nums1, nums2) + (double)advanceAndGet(nums1, nums2)) / 2;
		else
			result = advanceAndGet(nums1, nums2);

		return result;
	}

	private int advanceAndGet(int[] nums1, int[] nums2)
	{
		assert firstIndex < nums1.length;
		assert secondIndex < nums2.length;

		int result;

		if (isNextOutOfBounds(nums1, firstIndex))
		{
			secondIndex++;
			result = nums2[secondIndex];
		} else if (isNextOutOfBounds(nums2, secondIndex))
		{
			firstIndex++;
			result = nums1[firstIndex];
		} else if (nums1[firstIndex + 1] < nums2[secondIndex + 1])
		{
			firstIndex++;
			result = nums1[firstIndex];
		} else
		{
			secondIndex++;
			result = nums2[secondIndex];
		}

		return result;
	}

	private boolean isNextOutOfBounds(int[] nums, int index)
	{
		return index + 1 >= nums.length;
	}
}
