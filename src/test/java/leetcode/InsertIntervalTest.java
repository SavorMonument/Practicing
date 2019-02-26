package leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InsertIntervalTest
{
	InsertInterval insertInterval;

	@Before
	public void setUp() throws Exception
	{
		insertInterval = new InsertInterval();
	}

	@Test
	public void insert_1()
	{
		List<Interval> inputList = new ArrayList<>(Arrays.asList(new Interval(1, 3),
				new Interval(6, 9)));
		Interval intervalToInsert = new Interval(2, 5);

		List<Interval> expected = Arrays.asList(new Interval(1, 5), new Interval(6, 9));
		List<Interval> result = insertInterval.insert(inputList, intervalToInsert);

		assertArrayEquals(expected.toArray(), result.toArray());
	}

	@Test
	public void insert_2()
	{
		List<Interval> inputList = new ArrayList<>(Arrays.asList(new Interval(1, 2),
				new Interval(3, 5), new Interval(6, 7), new Interval(8, 10),
				new Interval(12, 16)));
		Interval intervalToInsert = new Interval(4, 8);

		List<Interval> expected = Arrays.asList(new Interval(1, 2), new Interval(3, 10),
				new Interval(12, 16));
		List<Interval> result = insertInterval.insert(inputList, intervalToInsert);

		assertArrayEquals(expected.toArray(), result.toArray());
	}

	@Test
	public void insert_3()
	{
		List<Interval> inputList = new ArrayList<>(Arrays.asList(new Interval(1, 2),
				new Interval(3, 5), new Interval(8, 10),
				new Interval(12, 16)));
		Interval intervalToInsert = new Interval(4, 8);

		List<Interval> expected = Arrays.asList(new Interval(1, 2), new Interval(3, 10),
				new Interval(12, 16));
		List<Interval> result = insertInterval.insert(inputList, intervalToInsert);

		assertArrayEquals(expected.toArray(), result.toArray());
	}

	@Test
	public void insert_4Begin()
	{
		List<Interval> inputList = new ArrayList<>(Arrays.asList(new Interval(3, 4),
				new Interval(6, 9)));
		Interval intervalToInsert = new Interval(0, 2);

		List<Interval> expected = Arrays.asList(new Interval(0, 2), new Interval(3, 4),
				new Interval(6, 9));
		List<Interval> result = insertInterval.insert(inputList, intervalToInsert);

		assertArrayEquals(expected.toArray(), result.toArray());
	}

	@Test
	public void insert_5End()
	{
		List<Interval> inputList = new ArrayList<>(Arrays.asList(new Interval(3, 4),
				new Interval(6, 9)));
		Interval intervalToInsert = new Interval(10, 15);

		List<Interval> expected = Arrays.asList(new Interval(3, 4), new Interval(6, 9),
				new Interval(10, 15));
		List<Interval> result = insertInterval.insert(inputList, intervalToInsert);

		assertArrayEquals(expected.toArray(), result.toArray());
	}

	@Test
	public void insert_6()
	{
		List<Interval> inputList = new ArrayList<>(Arrays.asList(new Interval(1, 2),
				new Interval(4, 5)));
		Interval intervalToInsert = new Interval(3, 6);

		List<Interval> expected = Arrays.asList(new Interval(1, 2), new Interval(3, 6));
		List<Interval> result = insertInterval.insert(inputList, intervalToInsert);

		assertArrayEquals(expected.toArray(), result.toArray());
	}

	@Test
	public void insert_7()
	{
		List<Interval> inputList = new ArrayList<>(Arrays.asList(new Interval(1, 2),
				new Interval(6, 7)));
		Interval intervalToInsert = new Interval(3, 4);

		List<Interval> expected = Arrays.asList(new Interval(1, 2), new Interval(3, 4),
				new Interval(6, 7));
		List<Interval> result = insertInterval.insert(inputList, intervalToInsert);

		assertArrayEquals(expected.toArray(), result.toArray());
	}

	@Test
	public void insert_8EmptyList()
	{
		List<Interval> inputList = new ArrayList<>();
		Interval intervalToInsert = new Interval(5, 7);

		List<Interval> expected = Arrays.asList(new Interval(5, 7));
		List<Interval> result = insertInterval.insert(inputList, intervalToInsert);

		assertArrayEquals(expected.toArray(), result.toArray());
	}

	@Test
	public void insert_9()
	{
		List<Interval> inputList = new ArrayList<>(Arrays.asList(new Interval(1, 5)));
		Interval intervalToInsert = new Interval(5, 7);

		List<Interval> expected = Arrays.asList(new Interval(1, 7));
		List<Interval> result = insertInterval.insert(inputList, intervalToInsert);

		assertArrayEquals(expected.toArray(), result.toArray());
	}
}