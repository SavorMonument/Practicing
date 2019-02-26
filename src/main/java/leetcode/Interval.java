package leetcode;

import java.util.Objects;

public class Interval
{
	public int start;
	public int end;

	Interval()
	{
		start = 0;
		end = 0;
	}

	Interval(int s, int e)
	{
		start = s;
		end = e;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Interval interval = (Interval) o;
		return start == interval.start &&
				end == interval.end;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(start, end);
	}
}
