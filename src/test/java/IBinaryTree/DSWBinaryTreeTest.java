package IBinaryTree;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class DSWBinaryTreeTest
{

	DSWBinaryTree bTree;

	@Before
	public void SetUp()
	{
		bTree = new DSWBinaryTree();
	}

	@Test
	public void addTestSameValue()
	{
		bTree.add(1);
		bTree.add(2);
		bTree.add(3);

		assertFalse(bTree.add(3));
	}

	@Test
	public void containsTest()
	{
		bTree.add(1);
		bTree.add(3);

		assertTrue(bTree.contains(3));
	}

	@Test
	public void containsFalseTest()
	{
		bTree.add(1);
		bTree.add(3);

		assertFalse(bTree.contains(4));
	}

	@Test
	public void deleteTest()
	{
		bTree.add(1);
		bTree.add(3);
		bTree.add(2);

		bTree.delete(3);

		assertTrue(bTree.contains(1) && bTree.contains(2));
	}

	@Test
	public void deleteBiggerTest()
	{
		bTree.add(4);
		bTree.add(8);
		bTree.add(6);
		bTree.add(9);
		bTree.add(7);
		bTree.add(5);

		bTree.delete(8);

		assertTrue(bTree.contains(4) &&
				bTree.contains(6) &&
				bTree.contains(9) &&
				bTree.contains(7) &&
				bTree.contains(5));
	}

	@Test
	public void stressTestDSW()
	{
		int values = 47_000;
		Random random = new Random();

		for (int i = 0; i < values; i++)
		{
			bTree.add(random.nextInt());
		}
		bTree.DSW();
	}

	@Test
	public void stressTestMakeIntoBackBoneIterative() throws NoSuchFieldException, IllegalAccessException
	{
		int values = 100_000;
		Random random = new Random();

		for (int i = 0; i < values; i++)
		{
			bTree.add(random.nextInt());
		}

		DSWBinaryTree.Node node = (DSWBinaryTree.Node) bTree.getHeadNode();

		node.makeIntoBackBoneIterative();
	}

	@Test
	public void stressTestNumOfNodesIterative() throws NoSuchFieldException, IllegalAccessException
	{
		int values = 80_000;
		Random random = new Random();

		for (int i = 0; i < values; i++)
		{
			bTree.add(random.nextInt());
		}

		DSWBinaryTree.Node node = (DSWBinaryTree.Node) bTree.getHeadNode();

		assertEquals(values, node.numOfNodesIterative());
	}
}