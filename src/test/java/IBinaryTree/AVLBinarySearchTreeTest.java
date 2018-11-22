package IBinaryTree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AVLBinarySearchTreeTest
{

	AVLBinarySearchTree bTree;

	@Before
	public void SetUp()
	{
		bTree = new AVLBinarySearchTree();
	}

	@Test
	public void addOneElem()
	{

		bTree.add(5);
	}

	@Test
	public void addMultipleElem()
	{

		bTree.add(5);
		bTree.add(15);
		bTree.add(25);
	}

	@Test
	public void addSameElemTwice()
	{
		int elem = 5;

		bTree.add(elem);
		assertFalse(bTree.add(elem));
	}

	@Test
	public void checkContains(){

		bTree.add(5);
		bTree.add(15);

		assert(bTree.contains(5) && bTree.contains(15));
	}

//	@Test
//	public void deleteAsSingleElem(){
//		int addedElem = 5;
//
//		bTree.add(addedElem);
//
//		assertFalse(bTree.contains(5));
//	}
//
//	@Test
//	public void deleteWhenMultiple(){
//		int addedElem = 5;
//
//		bTree.add(addedElem);
//		bTree.add(addedElem / 2);
//		bTree.add(addedElem * 2);
//		bTree.add(addedElem * 3);
//
//		bTree.delete(addedElem);
//
//		assertFalse(bTree.contains(addedElem));
//	}

	@Test
	public void size()
	{
		int addedElem = 5;

		bTree.add(addedElem);
		bTree.add(addedElem + 1);

		assertEquals(2, bTree.numOfNodes());
	}

	@Test
	public void sizeOnNone1()
	{

		assertEquals(0, bTree.numOfNodes());
	}

	@Test
	public void sizeOnNone2(){

		assertEquals(0, bTree.numOfNodes());
	}

	//
	// Nodes -----------------------------------------------------------
	//

	private AVLBinarySearchTree.Node getNodeInstance(int value, AVLBinarySearchTree.Node parent)
	{

		return bTree.getNodeInstance(value, parent);
	}

	@Test
	public void nodeRotationLeftOnHead()
	{
		AVLBinarySearchTree.Node first = getNodeInstance(1, null);
		AVLBinarySearchTree.Node second = getNodeInstance(2, first);
		AVLBinarySearchTree.Node third = getNodeInstance(3, second);
		AVLBinarySearchTree.Node forth = getNodeInstance(4, first);
		AVLBinarySearchTree.Node fifth = getNodeInstance(5, second);

		first.right = second;
		first.left = forth;
		second.right = third;
		second.left = fifth;

		first.balanceFactor = 2;

		first.leftRotate();

		assert (forth.parent == first);

		assert (first.parent == second);
		assert (first.left == forth);
		assert (first.right == fifth);

		assert (fifth.parent == first);

		assert (second.parent == null);
		assert (second.left == first);
		assert (second.right == third);

		assert (third.parent == second);

		assert (first.balanceFactor == 0);
		assert (second.balanceFactor == -2);
		assert (third.balanceFactor == 0);
		assert (forth.balanceFactor == 0);
		assert (fifth.balanceFactor == 0);
	}

	@Test
	public void nodeRotationLeftOnAChild()
	{
		AVLBinarySearchTree.Node first = getNodeInstance(1, null);
		AVLBinarySearchTree.Node second = getNodeInstance(2, first);
		AVLBinarySearchTree.Node third = getNodeInstance(3, second);
		AVLBinarySearchTree.Node forth = getNodeInstance(4, second);
		AVLBinarySearchTree.Node fifth = getNodeInstance(5, third);
		AVLBinarySearchTree.Node sixth = getNodeInstance(6, third);

		first.left = second;

		second.left = forth;
		second.right = third;

		third.left = sixth;
		third.right = fifth;

		second.leftRotate();

		assert (first.parent == null);
		assert (first.left == third);

		assert (third.parent == first);
		assert (third.left == second);
		assert (third.right == fifth);

		assert (second.parent == third);
		assert (second.left == forth);
		assert (second.right == sixth);

		assert (sixth.parent == second);

		assert (forth.parent == second);
	}

	@Test
	public void nodeRotationLeftOnLeftChildWithNoLeftNode()
	{
		AVLBinarySearchTree.Node first = getNodeInstance(1, null);
		AVLBinarySearchTree.Node second = getNodeInstance(2, first);
		AVLBinarySearchTree.Node third = getNodeInstance(3, second);

		first.left = second;

		second.right = third;

		second.leftRotate();

		assert (first.parent == null);
		assert (first.left == third);

		assert (third.parent == first);
		assert (third.left == second);

		assert (second.parent == third);
	}

	@Test
	public void nodeRotationLeftOnRightChildWithNoLeftNode()
	{
		AVLBinarySearchTree.Node first = getNodeInstance(1, null);
		AVLBinarySearchTree.Node second = getNodeInstance(2, first);
		AVLBinarySearchTree.Node third = getNodeInstance(3, second);

		first.right = second;

		second.right = third;

		second.leftRotate();

		assert (first.parent == null);
		assert (first.right == third);

		assert (third.parent == first);
		assert (third.left == second);

		assert (second.parent == third);
	}


	@Test
	public void nodeRotationRightOnHead()
	{
		AVLBinarySearchTree.Node first = getNodeInstance(1, null);
		AVLBinarySearchTree.Node second = getNodeInstance(2, first);
		AVLBinarySearchTree.Node third = getNodeInstance(3, second);
		AVLBinarySearchTree.Node forth = getNodeInstance(4, first);
		AVLBinarySearchTree.Node fifth = getNodeInstance(5, second);

		first.left = second;
		first.right = forth;
		second.left = third;
		second.right = fifth;

		first.rightRotate();

		assert (forth.parent == first);

		assert (first.parent == second);
		assert (first.left == fifth);
		assert (first.right == forth);

		assert (fifth.parent == first);

		assert (second.parent == null);
		assert (second.left == third);
		assert (second.right == first);

		assert (third.parent == second);
	}

	@Test
	public void nodeRotationRightOnAChild()
	{
		AVLBinarySearchTree.Node first = getNodeInstance(1, null);
		AVLBinarySearchTree.Node second = getNodeInstance(2, first);
		AVLBinarySearchTree.Node third = getNodeInstance(3, second);
		AVLBinarySearchTree.Node forth = getNodeInstance(4, second);
		AVLBinarySearchTree.Node fifth = getNodeInstance(5, third);
		AVLBinarySearchTree.Node sixth = getNodeInstance(6, third);

		first.right = second;

		second.left = third;
		second.right = forth;

		third.left = fifth;
		third.right = sixth;

		second.rightRotate();

		assert (first.parent == null);
		assert (first.right == third);

		assert (third.parent == first);
		assert (third.left == fifth);
		assert (third.right == second);

		assert (second.parent == third);
		assert (second.left == sixth);
		assert (second.right == forth);

		assert (sixth.parent == second);

		assert (forth.parent == second);
	}

	@Test
	public void nodeRotationRightOnRightChildWithNoRightNode()
	{
		AVLBinarySearchTree.Node first = getNodeInstance(1, null);
		AVLBinarySearchTree.Node second = getNodeInstance(2, first);
		AVLBinarySearchTree.Node third = getNodeInstance(3, second);

		first.right = second;

		second.left = third;

		second.rightRotate();

		assert (first.parent == null);
		assert (first.right == third);

		assert (third.parent == first);
		assert (third.right == second);

		assert (second.parent == third);
	}

	@Test
	public void nodeRotationRightOnLeftChildWithNoRightNode()
	{
		AVLBinarySearchTree.Node first = getNodeInstance(1, null);
		AVLBinarySearchTree.Node second = getNodeInstance(2, first);
		AVLBinarySearchTree.Node third = getNodeInstance(3, second);

		first.left = second;

		second.left = third;

		second.rightRotate();

		assert (first.parent == null);
		assert (first.left == third);

		assert (third.parent == first);
		assert (third.right == second);

		assert (second.parent == third);
	}

	@Test
	public void rebalanceLeftWithUnbalancedChildRight()
	{
		AVLBinarySearchTree.Node first = getNodeInstance(1, null);
		AVLBinarySearchTree.Node second = getNodeInstance(2, first);
		AVLBinarySearchTree.Node third = getNodeInstance(3, second);

		first.right = second;
		second.left = third;

		second.rebalanceUpChain();

		assert (first.parent == third);

		assert (third.parent == null);
		assert (third.left == first);
		assert (third.right == second);

		assert (second.parent == third);
	}

	@Test
	public void rebalanceLeftWithUnbalancedChildLeft()
	{
		AVLBinarySearchTree.Node first = getNodeInstance(1, null);
		AVLBinarySearchTree.Node second = getNodeInstance(2, first);
		AVLBinarySearchTree.Node third = getNodeInstance(3, second);

		first.left = second;
		second.right = third;

		second.rebalanceUpChain();

		assert (first.parent == third);

		assert (third.parent == null);
		assert (third.left == second);
		assert (third.right == first);

		assert (second.parent == third);
	}

	@Test
	public void rebalanceUpchain()
	{
		AVLBinarySearchTree.Node first = getNodeInstance(1, null);
		AVLBinarySearchTree.Node second = getNodeInstance(2, first);
		AVLBinarySearchTree.Node forth = getNodeInstance(4, second);
		AVLBinarySearchTree.Node third = getNodeInstance(3, forth);
		AVLBinarySearchTree.Node fifth = getNodeInstance(5, third);

		first.right = second;
		second.right = forth;
		forth.left = third;
		third.right = fifth;

		third.rebalanceUpChain();

		assert (second.parent == null);
		assert (second.left == first);
		assert (second.right == fifth);

		assert (fifth.parent == second);
		assert (fifth.left == third);
		assert (fifth.right == forth);

		assert (first.parent == second);

		assert (third.parent == fifth);

		assert (forth.parent == fifth);

		assert (first.balanceFactor == 0);
		assert (second.balanceFactor == 2);
		assert (third.balanceFactor == 0);
		assert (forth.balanceFactor == 0);
		assert (fifth.balanceFactor == 0);
	}


}