package leetcode;

import java.util.List;

public class InsertInterval
{
	public List<Interval> insert(List<Interval> intervals, Interval newInterval)
	{
		if (intervals.size() == 0)
			intervals.add(newInterval);

		for (int i = 0; i < intervals.size(); i++)
		{
			if (newInterval.end < intervals.get(i).start)
			{
				intervals.add(i, newInterval);
				break;
			}

			if (newInterval.start <= intervals.get(i).end)
			{
				int startOfInterval = Math.min(newInterval.start, intervals.get(i).start);

				int start = i;
				while(i + 1 < intervals.size() && intervals.get(i).end < newInterval.end
				&& intervals.get(i + 1).start <= newInterval.end)
					i++;

				Interval intervalToInsert = new Interval(startOfInterval,
						Math.max(intervals.get(i).end, newInterval.end));
				intervals.set(start, intervalToInsert);
				removeRange(intervals, start + 1, i + 1);
				break;
			}

			if (i == intervals.size() - 1)
				intervals.add(newInterval);
		}

		return intervals;
	}

	private void removeRange(List<Interval> intervals, int start, int end)
	{
		int amount = end - start;
		for (int i = 0; i < amount; i++)
			intervals.remove(start);
	}
}
