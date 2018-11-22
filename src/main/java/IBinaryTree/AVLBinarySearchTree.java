package IBinaryTree;

import edu.princeton.cs.algs4.Average;

public class AVLBinarySearchTree extends BinaryTree
{

	public boolean add(int value)
	{
		//Debug
//		System.out.println(elem);
//		printAsTree(System.out);

		if (null == head)
		{
			head = new Node(value, null);
			return true;
		} else
			return head.insert(value);
	}

	public static void main(String[] args)
	{
		AVLBinarySearchTree AVLTree = new AVLBinarySearchTree();
		DSWBinaryTree DSWTree = new DSWBinaryTree();

		AVLTree.add(200);
		AVLTree.add(210);
		AVLTree.add(220);
		AVLTree.add(230);
		AVLTree.add(240);
		AVLTree.add(250);
		AVLTree.add(260);
		AVLTree.add(500);
		AVLTree.add(300);
		AVLTree.add(700);
		AVLTree.add(800);
		AVLTree.add(900);
		AVLTree.add(901);
		AVLTree.add(902);
		AVLTree.add(903);

		DSWTree.add(200);
		DSWTree.add(210);
		DSWTree.add(220);
		DSWTree.add(230);
		DSWTree.add(240);
		DSWTree.add(250);
		DSWTree.add(260);
		DSWTree.add(500);
		DSWTree.add(300);
		DSWTree.add(700);
		DSWTree.add(800);
		DSWTree.add(900);
		DSWTree.add(901);
		DSWTree.add(902);
		DSWTree.add(903);

		AVLTree.printAsTree(System.out);
		DSWTree.DSW();
		DSWTree.printAsTree(System.out);
	}

	//Debug --------------------------------------------------
	public Node getNodeInstance(int value, Node parent)
	{
		return new Node(value, parent);
	}

	public void setHeadNode(Node node)
	{
		head = node;
	}
	//Debug --------------------------------------------------

	public class Node extends BinaryTree.Node
	{
		int balanceFactor;

		Node(int value, Node parent)
		{
			super(value, parent);
		}

		boolean insert(int inputValue)
		{
			if (inputValue != value)
			{
				if (inputValue < value)
				{
					if (left == null)
					{
						left = new Node(inputValue, this);
						((Node) left).rebalanceUpChain();
						return true;
					} else
						return left.insert(inputValue);
				} else
				{
					if (right == null)
					{
						right = new Node(inputValue, this);
						((Node) right).rebalanceUpChain();
						return true;
					} else
						return right.insert(inputValue);
				}
			}
			return false;
		}

		void rebalanceUpChain1()
		{
			balanceFactor = calculateBalanceFactor();
			if (this.balanceFactor > 1 || this.balanceFactor < -1)
			{
				this.rebalance();
				return;
			}

			if (null != parent)
			{
				if (parent.left == this)
					((Node) parent).balanceFactor -= 1;
				else if (parent.right == this)
					((Node) parent).balanceFactor += 1;

				if (((Node) parent).balanceFactor != 0)
					((Node) parent).rebalanceUpChain();
			}
		}

		@Override
		void leftRotate()
		{
			super.leftRotate();

			balanceFactor = calculateBalanceFactor();
			((Node)parent).balanceFactor = ((Node) parent).calculateBalanceFactor();

			//TODO: find the formula for calculating the balance factors without traversing the height of the tree
//			balanceFactor += - 1 + Math.max(((Node) parent).balanceFactor, 0);
//			((Node)parent).balanceFactor -= 1 + Math.min(balanceFactor, 0);
		}

		@Override
		void rightRotate()
		{
			super.rightRotate();

			balanceFactor = calculateBalanceFactor();
			((Node)parent).balanceFactor = ((Node) parent).calculateBalanceFactor();
		}

		void rebalanceUpChain()
		{
			balanceFactor = calculateBalanceFactor();
			if (balanceFactor > 1 || balanceFactor < -1)
			{
				BinaryTree.Node next = parent;
				rebalance();
				if (null != next)
					((Node) next).rebalanceUpChain();

			} else if (null != parent)
			{
				if (parent.left == this)
					((Node) parent).balanceFactor -= 1;
				else if (parent.right == this)
					((Node) parent).balanceFactor += 1;

//				if (((Node) parent).balanceFactor != 0)
				((Node) parent).rebalanceUpChain();
			}
		}

	 	private void rebalance()
		{
			if (balanceFactor > 1)
			{
				if (((Node) right).balanceFactor < 0)
					right.rightRotate();
				leftRotate();
			} else if (balanceFactor < -1)
			{
				if (((Node) left).balanceFactor > 0)
					left.leftRotate();
				rightRotate();
			}
		}

		//Should not be used in final version, used for debug
		int calculateBalanceFactor()
		{
			int factor = 0;

			if (null != left)
				factor -= left.numOfNodes();

			if (null != right)
				factor += right.numOfNodes();

			return factor;
		}

		boolean delete(int elem)
		{

			return false;
		}
	}
}
