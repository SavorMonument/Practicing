package PPerlas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RVectorTest {

    private String str;

    @Before
    public void SetUp(){

        str = "abcdefgh";
    }

    @Test
    public void RotateTest1(){

        str = RVector.rotate(str, 1);

        assertEquals("bcdefgha", str);
    }

    @Test
    public void RotateTest2(){

        str = RVector.rotate(str, 2);

        assertEquals("cdefghab", str);
    }

    @Test
    public void RotateTest3(){

        str = RVector.rotate(str, 8);

        assertEquals("abcdefgh", str);
    }


    @Test
    public void RotateTest4(){

        str = RVector.rotate(str, 0);

        assertEquals("abcdefgh", str);
    }

    @Test
    public void RotateV2Test1(){

        str = RVector.rotateV2(str, 1);

        assertEquals("bcdefgha", str);
    }

    @Test
    public void RotateV2Test2(){

        str = RVector.rotateV2(str, 2);

        assertEquals("cdefghab", str);
    }

    @Test
    public void RotateV2Test3(){

        str = RVector.rotateV2(str, 8);

        assertEquals("abcdefgh", str);
    }


    @Test
    public void RotateV2Test4(){

        str = RVector.rotateV2(str, 0);

        assertEquals("abcdefgh", str);
    }

    @Test
    public void RotateV3Test1(){

        str = RVector.rotateV3(str, 1);

        assertEquals("bcdefgha", str);
    }

    @Test
    public void RotateV3Test2(){

        str = RVector.rotateV3(str, 2);

        assertEquals("cdefghab", str);
    }

    @Test
    public void RotateV3Test3(){

        str = RVector.rotateV3(str, 8);

        assertEquals("abcdefgh", str);
    }


    @Test
    public void RotateV3Test4(){

        str = RVector.rotateV3(str, 0);

        assertEquals("abcdefgh", str);
    }
}