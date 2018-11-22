package IBinaryTree;

public class DSWBinaryTree extends BinaryTree
{

	//Debug ------------------------------------------------------
	public static void main(String[] args)
	{
		DSWBinaryTree bTree = new DSWBinaryTree();

		bTree.add(240);
		bTree.add(250);
		bTree.add(210);
		bTree.add(280);
		bTree.add(240);
		bTree.add(290);
		bTree.add(300);
		bTree.add(310);
		bTree.add(260);
		bTree.add(140);
		bTree.add(120);
		bTree.add(130);
		bTree.add(100);
		bTree.add(500);
		bTree.add(300);
		bTree.add(700);
		bTree.add(800);
		bTree.add(900);
		bTree.add(901);
		bTree.add(902);
		bTree.add(903);

		bTree.DSW();
		bTree.printAsTree(System.out);
	}
	//Debug ------------------------------------------------------

	@Override
	boolean add(int value)
	{
		if (null == head)
		{
			head = new Node(value, null);
			return true;
		} else
			return head.insert(value);
	}
	//Day stout warren algorithm, works up to around 47_000 nodes after witch you get stack overflow in rotateLeftNTimes(),
	//the function could be changed to an iterative one(too lazy to do that now)
	public void DSW()
	{
		((Node) head).makeIntoBackBoneIterative();

		int nodeCount = head.numOfNodesIterative();
		int expectedLeaves = nodeCount + 1 - (int) Math.pow(2, logN(nodeCount + 1, 2));

		((Node) head).rotateLeftNTimes(expectedLeaves);

		//Number of nodes left on the backbone
		int times = nodeCount - expectedLeaves;
		while (times > 1)
		{
			times /= 2;
			((Node) head).rotateLeftNTimes(times);
		}
	}

	private int logN(int nr, int base)
	{
		return (int) (Math.log(nr) / Math.log(base));
	}

	//Used for testing purposes
	public BinaryTree.Node getHeadNode(){

		return head;
	}

	class Node extends BinaryTree.Node
	{
		public Node(int value, Node parent)
		{
			super(value, parent);
		}

		@Override
		boolean insert(int inputValue)
		{
			if (inputValue < value)
			{
				if (null != left)
					return left.insert(inputValue);
				else
				{
					left = new Node(inputValue, this);
					return true;
				}
			} else if (inputValue > value)
			{
				if (null != right)
					return right.insert(inputValue);
				else
				{
					right = new Node(inputValue, this);
					return true;
				}
			}
			return false;
		}

		@Override
		boolean delete(int inputValue)
		{
			if (inputValue == value)
			{
				if (parent.left == this)
				{
					parent.left = left;
					if (null != left)
						left.parent = parent;
					if (null != right)
						((Node) right).reinsertRecursively();
				} else
				{
					parent.right = right;
					if (null != right)
						right.parent = parent;
					if (null != left)
						((Node) left).reinsertRecursively();
				}
				return true;
			} else
			{
				if (inputValue < value && null != left)
					return left.delete(inputValue);
				else if (null != right)
					return right.delete(inputValue);
				else return false;
			}
		}

		private void reinsertRecursively()
		{
			if (null != left)
			{
				((Node) (left)).reinsertRecursively();
			}
			if (null != right)
			{
				((Node) (right)).reinsertRecursively();
			}
			head.insert(value);
		}

		void makeIntoBackBoneIterative()
		{
			Node current = this;

			while (null != current.left)
			{
				current.rightRotate();
				current = (Node)current.parent;
				while (null == current.left && null != current.right)
				{
					current = (Node)current.right;
				}
			}
		}
		//This throws stack overflow at around 7_000
		void makeIntoBackBone()
		{
			if (null != left)
			{
				rightRotate();
				((Node) parent).makeIntoBackBone();
				return;
			}
			if (null != right)
				((Node) right).makeIntoBackBone();
		}

		private void rotateLeftNTimes(int n)
		{
			if (n > 0)
			{
				leftRotate();
				if (null != parent.right)
					((Node) parent.right).rotateLeftNTimes(n - 1);
			}
		}
	}
}
