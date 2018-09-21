package StringCompression;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompressorTest {


    @Test
    public void noCompressionString(){

        String str = "I got nothing";

        String compressed = Compressor.compressString(str);

        assertEquals(str, compressed);
    }

    @Test
    public void regularCompressionString(){

        String str = "aaa  acccac bb";
        String expected = "a3 2ac3ac b2";

        String compressed = Compressor.compressString(str);

        assertEquals(expected, compressed);
    }

    @Test
    public void regularCompressionBuilderString(){

        String str = "aaa  acccac bb";
        String expected = "a3 2ac3ac b2";

        String compressed = Compressor.compressStringBuilder(str);

        assertEquals(expected, compressed);
    }

    @Test
    public void regularCompressionCharArray(){

        char[] str = {'a', 'a', 'a', ' ', ' ', 'a', 'c', 'c', 'c', 'a', 'c',' ', 'b', 'b'};
        char[] expected = {'a', '3', ' ', '2', 'a', 'c', '3', 'a', 'c',' ', 'b', '2'};

        char[] compressed = Compressor.compressStringCharArray(str);

        assertEquals(new String(expected),new String(compressed));
    }

    @Test
    public void regularCompressionBigCharArray(){

        char[] str = {'a', 'a', 'a', ' ', ' ', 'a', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'a', 'c',' ', 'b', 'b'};
        char[] expected = {'a', '3', ' ', '2', 'a', 'c', '1', '0', 'a', 'c',' ', 'b', '2'};

        char[] compressed = Compressor.compressStringCharArray(str);

        assertEquals(new String(expected),new String(compressed));
    }
}