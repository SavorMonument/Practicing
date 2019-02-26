package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwapNodesTest
{

	SwapNodes swapNodes;

	@Before
	public void setUp() throws Exception
	{
		swapNodes = new SwapNodes();
	}

	private ListNode getListWithValues(int... values)
	{
		if (values.length == 0)
			return null;

		ListNode head = new ListNode(values[0]);
		ListNode current = head;

		int i = 1;
		while (i < values.length)
		{
			current.next = new ListNode(values[i]);
			current = current.next;
			i++;
		}

		return head;
	}

	private String ListNodesToString(ListNode head)
	{
		StringBuilder formatted = new StringBuilder();

		while (null != head)
		{
			formatted.append(head.val);
			if (null != head.next)
				formatted.append("->");
			head = head.next;
		}

		return formatted.toString();
	}

	private void assertMatchingNodes(ListNode expectedHead, ListNode resultHead)
	{
		ListNode currentNodeExpected = expectedHead;
		ListNode currentNodeResult = resultHead;

		while (null != currentNodeExpected && null != currentNodeResult)
		{
			if (currentNodeExpected.val != currentNodeResult.val)
				throw new AssertionError(String.format("The node values were different\nExpected: %s\nResult: %s",
						ListNodesToString(expectedHead), ListNodesToString(resultHead)));

			currentNodeExpected = currentNodeExpected.next;
			currentNodeResult = currentNodeResult.next;
		}

		if (null != currentNodeExpected)
			throw new AssertionError(String.format("The node values were different\nExpected: %s\nResult: %s",
					ListNodesToString(expectedHead), ListNodesToString(resultHead)));

		if (null != currentNodeResult)
			throw new AssertionError(String.format("The node values were different\nExpected: %s\nResult: %s",
					ListNodesToString(expectedHead), ListNodesToString(resultHead)));
	}

	@Test
	public void testTheHelpers()
	{
		assertMatchingNodes(getListWithValues(1, 2, 3), getListWithValues(1, 2, 3));
	}

	@Test(expected = AssertionError.class)
	public void testTheHelpers_Failure()
	{
		assertMatchingNodes(getListWithValues(1, 2, 3), getListWithValues(1, 1, 3));
	}

	@Test
	public void swapPairs()
	{
		ListNode inputNodes = getListWithValues(1, 2, 3, 4);

		ListNode expectedNodes = getListWithValues(2, 1, 4, 3);
		ListNode resultNodes = swapNodes.swapPairs(inputNodes);

		assertMatchingNodes(expectedNodes, resultNodes);
	}
}