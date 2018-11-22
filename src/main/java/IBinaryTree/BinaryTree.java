package IBinaryTree;

import tables.Table;

import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public abstract class BinaryTree
{
	protected Node head;

	abstract boolean add(int value);

	public void printInOrder()
	{
		if (null != head)
			head.print(System.out);
	}

	public boolean delete(int elem)
	{
		if (null != head)
			return head.delete(elem);
		else
			return false;
	}


	public boolean contains(int elem)
	{
		if (null == head)
			return false;
		else
			return head.contains(elem);
	}

	public int height()
	{
		if (null == head)
			return 0;
		else
			return head.height();
	}

	public int numOfNodes()
	{
		if (null == head)
			return 0;
		else
			return head.numOfNodes();
	}

	public void printAsTree(PrintStream pStream)
	{
		if (null != head)
		{
			Table.TableBuilder builder = new Table.TableBuilder();
			builder.setNumberedTable((int) Math.pow(2, height()) + 1, height());
			builder.setExtraPadding(1);

			Table table = builder.build();

			head.fillTable(table, 0, (int) (Math.pow(2, height()) / 2));
			table.print(pStream);
		}
	}

	abstract class Node
	{

		int value;
		Node parent;
		Node left;
		Node right;

		Node(int value, Node parent)
		{
			this.value = value;
			this.parent = parent;
		}

		abstract boolean insert(int inputValue);

		abstract boolean delete(int inputValue);

		void leftRotate()
		{
			Node temp = right.left;

			right.left = this;
			right.parent = parent;

			if (null == parent)
			{
				head = right;
				parent = right;
			} else
			{
				if (parent.left == this)
					parent.left = right;
				else
					parent.right = right;
				parent = right;
			}
			right = temp;
			if (null != temp)
				temp.parent = this;
		}

		void rightRotate()
		{
			BinaryTree.Node temp = left.right;

			left.parent = parent;
			left.right = this;
			if (null == parent)
			{
				head = left;
				parent = left;
			} else
			{
				if (parent.right == this)
					parent.right = left;
				else
					parent.left = left;

				parent = left;
			}
			left = temp;
			if (null != temp)
				temp.parent = this;
		}

		int height()
		{
			int sizeLeft = 0;
			int sizeRight = 0;

			if (null != left)
				sizeLeft += left.height();

			if (null != right)
				sizeRight += right.height();

			return Math.max(sizeLeft, sizeRight) + 1;
		}

		void print(PrintStream stream)
		{
			if (null != left)
				left.print(stream);

			stream.print(value);

			if (null != right)
				right.print(stream);
		}

		boolean contains(int inputValue)
		{
			if (inputValue == value)
				return true;
			else
			{
				if (inputValue < value && null != left)
					return left.contains(inputValue);
				else if (null != right)
					return right.contains(inputValue);
				else return false;
			}
		}

		int numOfNodesIterative()
		{
			Queue<Node> que = new LinkedList<>();
			int size = 0;
			Node current = this;

			while (null != current)
			{
				if (null != current.right)
				{
					que.add(current.right);
					size++;
				}

				current = current.left;

				if (null == current && !que.isEmpty())
					current = que.poll();
				else
					size++;
			}

			return size;
		}

		int numOfNodes()
		{
			int size = 1;

			if (null != left)
				size += left.numOfNodes();

			if (null != right)
				size += right.numOfNodes();

			return size;
		}

		void fillTable(Table table, int row, int col)
		{
			table.addElement(String.valueOf(row), String.valueOf(col), value);

			int height = (int) Math.pow(2, Math.max(null != left ? left.height() : 0, null != right ? right.height() : 0) - 1);

			if (null != left)
				left.fillTable(table, row + 1, col - height);

			if (null != right)
				right.fillTable(table, row + 1, col + height);
		}
	}
}
