package TopCoder.IBinaryTree;

import IBinaryTree.BinaryTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class BinaryTreeTest {

    BinaryTree bTree;

    @Before
    public void setUp() throws Exception {

        bTree = new BinaryTree();
    }

    @After
    public void tearDown() throws Exception {

        bTree = null;
    }

    @Test
    public void addELem(){

        bTree.addInt(5);

        assertTrue (bTree.contains(5));
    }

    @Test
    public void add2ELem(){

        bTree.addInt(5);
        bTree.addInt(2);

        assertTrue (bTree.contains(2));
    }

    @Test
    public void add3ELem(){

        bTree.addInt(5);
        bTree.addInt(2);
        bTree.addInt(6);

        assertTrue (bTree.contains(6));
    }

    @Test
    public void add4ELem(){

        bTree.addInt(5);
        bTree.addInt(2);
        bTree.addInt(7);
        bTree.addInt(1);
        bTree.addInt(9);

        assertTrue (bTree.contains(9));
    }

    @Test
    public void delete(){

        bTree.addInt(25);
        bTree.addInt(30);
        bTree.addInt(27);
        bTree.addInt(31);
        bTree.addInt(26);
        bTree.addInt(29);
        bTree.addInt(32);

        bTree.delete(30);

        assertTrue(bTree.contains(29));
        assertFalse(bTree.contains(30));
    }

    @Test
    public void delete2(){

        bTree.addInt(25);
        bTree.addInt(13);
        bTree.addInt(18);
        bTree.addInt(16);
        bTree.addInt(5);
        bTree.addInt(3);
        bTree.addInt(8);

        bTree.delete(13);

        assertTrue(bTree.contains(3));
        assertFalse(bTree.contains(13));
    }
}