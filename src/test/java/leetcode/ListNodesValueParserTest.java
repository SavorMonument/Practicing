package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListNodesValueParserTest
{
	ListNodesValueParser listNodesValueParser;

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void ListParse()
	{
		String input = "[[2, 3],[5],[7, 8, 9]]";

		ListNode[] listNodesExpected = new ListNode[]{getListWithValues(2, 3), getListWithValues(5), getListWithValues(7, 8, 9)};
		listNodesValueParser = new ListNodesValueParser(input);

		assertMatchingNodes(listNodesExpected[0], listNodesValueParser.getNextList());
		assertMatchingNodes(listNodesExpected[1], listNodesValueParser.getNextList());
		assertMatchingNodes(listNodesExpected[2], listNodesValueParser.getNextList());
	}

	@Test
	public void ListParse2()
	{
		String input = "[[2],[5],[7]]";

		ListNode[] listNodesExpected = new ListNode[]{getListWithValues(2), getListWithValues(5), getListWithValues(7)};
		listNodesValueParser = new ListNodesValueParser(input);

		assertMatchingNodes(listNodesExpected[0], listNodesValueParser.getNextList());
		assertMatchingNodes(listNodesExpected[1], listNodesValueParser.getNextList());
		assertMatchingNodes(listNodesExpected[2], listNodesValueParser.getNextList());
	}

	@Test(expected = IllegalStateException.class)
	public void listParse_NoLists()
	{
		String input = "[]";

		listNodesValueParser = new ListNodesValueParser(input);
		listNodesValueParser.getNextList();
	}

	@Test(expected = IllegalStateException.class)
	public void listParse_ExceptionifAskingAfterLast()
	{
		String input = "[[2, 3]]";

		listNodesValueParser = new ListNodesValueParser(input);
		listNodesValueParser.getNextList();
		listNodesValueParser.getNextList();
	}

	@Test
	public void hasMoreItems_True()
	{
		String input = "[[2, 3]]";

		listNodesValueParser = new ListNodesValueParser(input);

		assertTrue(listNodesValueParser.hasMoreItems());
	}

	@Test
	public void hasMoreItems()
	{
		String input = "[[2, 3]]";

		listNodesValueParser = new ListNodesValueParser(input);

		listNodesValueParser.getNextList();
		assertFalse (listNodesValueParser.hasMoreItems());
	}

	@Test
	public void hasMoreItems_EmptyLists()
	{
		String input = "[[]]";

		listNodesValueParser = new ListNodesValueParser(input);

		listNodesValueParser.getNextList();
		assertFalse (listNodesValueParser.hasMoreItems());
	}

	@Test
	public void hasMoreItems_NoLists()
	{
		String input = "[]";

		listNodesValueParser = new ListNodesValueParser(input);

		assertFalse (listNodesValueParser.hasMoreItems());
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
}