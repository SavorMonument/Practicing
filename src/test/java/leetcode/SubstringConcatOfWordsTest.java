package leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SubstringConcatOfWordsTest
{

	SubstringConcatOfWords substringConcatOfWords;

	@Before
	public void setUp() throws Exception
	{
		substringConcatOfWords = new SubstringConcatOfWords();
	}

	@Test
	public void findSubstring1()
	{
		String inputString = "barfoothefoobarman";
		String[] words = new String[]{"foo", "bar"};

		List<Integer> expected = Arrays.asList(0, 9);
		List<Integer> result = substringConcatOfWords.findSubstring(inputString, words);

		assertArrayEquals(expected.toArray(), result.toArray());
	}

	@Test
	public void findSubstring2()
	{
		String inputString = "wordgoodgoodgoodbestword";
		String[] words = new String[]{"word","good","best","word"};

		List<Integer> expected = new ArrayList<>(Arrays.asList());
		List<Integer> result = substringConcatOfWords.findSubstring(inputString, words);

		assertArrayEquals(expected.toArray(), result.toArray());
	}

	@Test
	public void findSubstring3()
	{
		String inputString = "aaaaaaaa";
		String[] words = new String[]{"aa","aa","aa"};

		List<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 2));
		List<Integer> result = substringConcatOfWords.findSubstring(inputString, words);

		assertArrayEquals(expected.toArray(), result.toArray());
	}

	@Test
	public void findSubstring4()
	{
		String inputString = "";
		String[] words = new String[]{};

		List<Integer> expected = new ArrayList<>(Arrays.asList());
		List<Integer> result = substringConcatOfWords.findSubstring(inputString, words);

		assertArrayEquals(expected.toArray(), result.toArray());
	}

	@Test
	public void findSubstring5()
	{
		String inputString = "";
		String[] words = new String[]{};

		List<Integer> expected = new ArrayList<>(Arrays.asList());
		List<Integer> result = substringConcatOfWords.findSubstring(inputString, words);

		assertArrayEquals(expected.toArray(), result.toArray());
	}
}