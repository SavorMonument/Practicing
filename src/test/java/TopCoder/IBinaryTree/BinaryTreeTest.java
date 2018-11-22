package TopCoder.IBinaryTree;

import IBinaryTree.AVLBinarySearchTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class BinaryTreeTest {

    AVLBinarySearchTree bTree;

    @Before
    public void setUp() throws Exception {

        bTree = new AVLBinarySearchTree();
    }

    @After
    public void tearDown() throws Exception {

        bTree = null;
    }

    @Test
    public void addELem(){

        bTree.add(5);

        assertTrue (bTree.contains(5));
    }

    @Test
    public void add2ELem(){

        bTree.add(5);
        bTree.add(2);

        assertTrue (bTree.contains(2));
    }

    @Test
    public void add3ELem(){

        bTree.add(5);
        bTree.add(2);
        bTree.add(6);

        assertTrue (bTree.contains(6));
    }

    @Test
    public void add4ELem(){

        bTree.add(5);
        bTree.add(2);
        bTree.add(7);
        bTree.add(1);
        bTree.add(9);

        assertTrue (bTree.contains(9));
    }

    @Test
    public void delete(){

        bTree.add(25);
        bTree.add(30);
        bTree.add(27);
        bTree.add(31);
        bTree.add(26);
        bTree.add(29);
        bTree.add(32);

        bTree.delete(30);

        assertTrue(bTree.contains(29));
        assertFalse(bTree.contains(30));
    }

    @Test
    public void delete2(){

        bTree.add(25);
        bTree.add(13);
        bTree.add(18);
        bTree.add(16);
        bTree.add(5);
        bTree.add(3);
        bTree.add(8);

        bTree.delete(13);

        assertTrue(bTree.contains(3));
        assertFalse(bTree.contains(13));
    }
}