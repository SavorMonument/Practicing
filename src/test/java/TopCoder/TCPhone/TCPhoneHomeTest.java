package TopCoder.TCPhone;

import org.junit.Test;

import static org.junit.Assert.*;

public class TCPhoneHomeTest {

    TCPhoneHome tHome = new TCPhoneHome();



    @Test
    public void test1(){

        String[] prefixes = {"0", "1" , "911"};
        int numberOfDigits = 7;
        long expected = 7990000;

        assertEquals(expected, tHome.validNumbers(numberOfDigits, prefixes));
    }

    @Test
    public void test2(){

        String[] prefixes = {"0", "1" , "911"};
        int numberOfDigits = 10;
        long expected = 7990000000L;

        assertEquals(expected, tHome.validNumbers(numberOfDigits, prefixes));
    }

    @Test
    public void test3(){

        String[] prefixes = {"1", "12" , "123"};
        int numberOfDigits = 8;
        long expected = 90000000;

        assertEquals(expected, tHome.validNumbers(numberOfDigits, prefixes));
    }

    @Test
    public void test31(){

        String[] prefixes = {"123", "12" , "1"};
        int numberOfDigits = 8;
        long expected = 90000000;

        assertEquals(expected, tHome.validNumbers(numberOfDigits, prefixes));
    }

    @Test
    public void test4(){

        String[] prefixes = {"12", "13" , "14"};
        int numberOfDigits = 9;
        long expected = 970000000;

        assertEquals(expected, tHome.validNumbers(numberOfDigits, prefixes));
    }

    @Test
    public void test5(){

        String[] prefixes = {"411"};
        int numberOfDigits = 3;
        long expected = 999;

        assertEquals(expected, tHome.validNumbers(numberOfDigits, prefixes));
    }

    @Test
    public void test6(){

        String[] prefixes = {"411", "411"};
        int numberOfDigits = 3;
        long expected = 999;

        assertEquals(expected, tHome.validNumbers(numberOfDigits, prefixes));
    }

    @Test
    public void isPrefix(){

        assert (tHome.isPrefix("123", "1"));
    }

    @Test
    public void isPrefix2(){

        assert (!tHome.isPrefix("123", "132"));
    }

    @Test
    public void isPrefix3(){

        assert (!tHome.isPrefix("123", "1213"));
    }

    @Test
    public void isPrefix4(){

        assert (tHome.isPrefix("123", "123"));
    }
}