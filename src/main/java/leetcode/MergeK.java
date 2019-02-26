package leetcode;

import java.util.*;

public class MergeK
{
	public ListNode mergeKListsUsingSort(ListNode[] lists)
	{

		ListNode resultHead = new ListNode(0);
		ListNode currentResultNode = resultHead;

		List<ListNode> listNodes = new ArrayList<>(Arrays.asList(lists));
		removeEmptyLists(listNodes);

		while (!listNodes.isEmpty())
		{
			listNodes.sort((o1, o2) -> Integer.compare(o1.val, o2.val));

			currentResultNode.next = new ListNode(listNodes.get(0).val);
			currentResultNode = currentResultNode.next;
			listNodes.set(0, listNodes.get(0).next);

			if (null == listNodes.get(0))
				listNodes.remove(0);
		}

		return resultHead.next;
	}

	private List<ListNode> getLinkedList(ListNode[] lists)
	{
		List<ListNode> result = new LinkedList<>();

		for (ListNode node : lists)
		{
			result.add(node);
		}

		return result;
	}

	public ListNode mergeKLists(ListNode[] lists)
	{
		ListNode resultHead = new ListNode(0);
		ListNode currentResultNode = resultHead;

		List<ListNode> listNodes = new LinkedList<>(Arrays.asList(lists));
		removeEmptyLists(listNodes);

		while (!listNodes.isEmpty())
		{
			Iterator<ListNode> it = listNodes.iterator();
			int index = 0;
			int minIndex = index;
			ListNode minNode = it.next();

			while (it.hasNext())
			{
				index++;
				ListNode currentNode = it.next();
				if (currentNode.val < minNode.val)
				{
					minNode = currentNode;
					minIndex = index;
				}
			}

			currentResultNode.next = minNode;
			currentResultNode = currentResultNode.next;
			if (null == minNode.next)
				listNodes.remove(minIndex);
			else
				listNodes.set(minIndex, minNode.next);
		}

		return resultHead.next;
	}

	public ListNode mergeKListsArray(ListNode[] lists)
	{
		ListNode resultHead = new ListNode(0);
		ListNode currentResultNode = resultHead;

		List<ListNode> listNodes = new ArrayList<>(Arrays.asList(lists));
		removeEmptyLists(listNodes);

		while (!listNodes.isEmpty())
		{
			int minIndex = 0;
			ListNode minNode = listNodes.get(minIndex);

			for (int i = 1; i < listNodes.size(); i++)
			{
				if (listNodes.get(i).val < minNode.val)
				{
					minNode = listNodes.get(i);
					minIndex = i;
				}
			}

			currentResultNode.next = minNode;
			currentResultNode = currentResultNode.next;
			if (null == minNode.next)
				listNodes.remove(minIndex);
			else
				listNodes.set(minIndex, minNode.next);
		}

		return resultHead.next;
	}


	private void removeEmptyLists(List<ListNode> listNodes)
	{
		listNodes.removeIf(listNode -> null == listNode);
	}
}
