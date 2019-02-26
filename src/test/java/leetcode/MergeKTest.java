package leetcode;

import mine.DeltaTime;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.InflaterInputStream;

import static org.junit.Assert.*;

public class MergeKTest
{
	MergeK mergeK;

	@Before
	public void setUp() throws Exception
	{
		mergeK = new MergeK();
	}

	@Test
	public void mergeKLists()
	{
		ListNode listNodes1 = getListWithValues(1, 4, 5);
		ListNode listNodes2 = getListWithValues(1, 3, 4);
		ListNode listNodes3 = getListWithValues(2, 6);

		ListNode expectedNodes = getListWithValues(1, 1, 2, 3, 4, 4, 5, 6);
		ListNode resultNodes = mergeK.mergeKLists(new ListNode[]{listNodes1, listNodes2, listNodes3});

		assertMatchingNodes(expectedNodes, resultNodes);
	}

	@Test
	public void mergeKLists2()
	{
		ListNode listNodes1 = getListWithValues();
		ListNode listNodes2 = getListWithValues(1, 3, 4);
		ListNode listNodes3 = getListWithValues(2, 6);

		ListNode expectedNodes = getListWithValues(1, 2, 3, 4, 6);
		ListNode resultNodes = mergeK.mergeKListsUsingSort(new ListNode[]{listNodes1, listNodes2, listNodes3});

		assertMatchingNodes(expectedNodes, resultNodes);
	}

	@Test
	public void mergeKLists3() throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream("resources/MergeTestCase.txt"),
				StandardCharsets.UTF_8));

		String testCase = reader.readLine();

		ListNodesValueParser listNodesValueParser = new ListNodesValueParser(testCase);

		List<ListNode> listNodes = new LinkedList<>();
		while (listNodesValueParser.hasMoreItems())
		{
			listNodes.add(listNodesValueParser.getNextList());
		}

		DeltaTime deltaTime = new DeltaTime();
		mergeK.mergeKLists(listNodes.toArray(new ListNode[0]));
		System.out.println(deltaTime.getElapsedTimeSeconds() + "s");
	}

	private int[] getNextListValues()
	{

		return null;
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