package leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LetterCombinationsTest
{

	LetterCombinations letterCombinations;

	@Before
	public void setUp() throws Exception
	{
		letterCombinations = new LetterCombinations();
	}

	@Test
	public void letterCombinations()
	{
		String input = "23";

		List<String> expected = new ArrayList<>(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
		List<String> result = letterCombinations.letterCombinations(input);

		assertArrayEquals(expected.toArray(), result.toArray());
	}

	@Test
	public void letterCombinations_Empty()
	{
		String input = "";

		List<String> expected = new ArrayList<>();
		List<String> result = letterCombinations.letterCombinations(input);

		assertArrayEquals(expected.toArray(), result.toArray());
	}
}