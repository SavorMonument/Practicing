package leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZigZagTest
{
	ZigZag zigZag;

	@Before
	public void setUp() throws Exception
	{
		zigZag = new ZigZag();
	}

	@After
	public void tearDown() throws Exception
	{

	}

	@Test
	public void convert_First()
	{
		String inputString = "PAYPALISHIRING";

		String expected = "PAHNAPLSIIGYIR";
		String result = zigZag.convert(inputString, 3);

		assertEquals(expected, result);
	}

	@Test
	public void convert_Second()
	{
		String inputString = "PAYPALISHIRING";

		String expected = "PINALSIGYAHRPI";
		String result = zigZag.convert(inputString, 4);

		assertEquals(expected, result);
	}
}