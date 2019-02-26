package leetcode;

import java.util.Scanner;

//Parses [[2, 3],[5],[7, 8, 9]] to lists of ListNodes
class ListNodesValueParser
{
	private String[] listTokens;
	private int currentIndex = 0;

	public ListNodesValueParser(String input)
	{
		if (input.length() < 4)
			listTokens = new String[0];
		else
		{
			input = input.substring(2, input.length() - 2);
			this.listTokens = input.split("],\\[");
		}
	}

	public ListNode getNextList()
	{
		if (currentIndex == listTokens.length)
			throw new IllegalStateException("No more elments");

		ListNode aboveHead = new ListNode(0);
		ListNode currentNode = aboveHead;
		Scanner scanner = new Scanner(listTokens[currentIndex]);
		scanner.useDelimiter(", ");

		while (scanner.hasNextInt())
		{
			currentNode.next = new ListNode(scanner.nextInt());
			currentNode = currentNode.next;
		}

		currentIndex++;
		return aboveHead.next;
	}

	public boolean hasMoreItems()
	{
		return currentIndex < listTokens.length;
	}
}