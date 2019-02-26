package leetcode;

public class SwapNodes
{

	public ListNode swapPairs(ListNode head)
	{
		if (null == head)
			return null;

		ListNode pointerToHead = new ListNode(0);
		pointerToHead.next = head;

		ListNode current = pointerToHead;
		while (null != current.next && null != current.next.next)
		{
			ListNode temp = current.next;
			current.next = current.next.next;
			temp.next = current.next.next;
			current.next.next = temp;

			current = current.next.next;
		}

		return pointerToHead.next;
	}
}
