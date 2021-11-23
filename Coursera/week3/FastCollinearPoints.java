package week3;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {

	private ArrayList<LineSegment> segmentStack = new ArrayList<>();

	public FastCollinearPoints(Point[] points) {
		if (points == null || hasDuplicate(points) || hasNull(points))
			throw new IllegalArgumentException();

		Point[] copy = points.clone();
		Arrays.sort(copy);

		for (int i = 0; i < copy.length - 3; i++) {
			Arrays.sort(copy);
			Arrays.sort(copy, copy[i].slopeOrder());

			for (int p = 0, first = 1, last = 2; last < copy.length; last++) {
				while (last < copy.length && (copy[p].slopeTo(copy[first]) == copy[p].slopeTo(copy[last])))
					last++;

				if (last - first >= 3 && copy[p].compareTo(copy[first]) < 0)
					segmentStack.add(new LineSegment(copy[p], copy[last - 1]));

				first = last;
			}
		}

	}

	public int numberOfSegments() {
		return segmentStack.size();
	}

	public LineSegment[] segments() {
		return segmentStack.toArray(new LineSegment[segmentStack.size()]);
	}

	private static boolean hasDuplicate(Point[] points) {

		for (int i = 0; i < points.length - 1; i++)
			for (int j = i + 1; j < points.length; j++)
				if (points[i].compareTo(points[j]) == 0)
					return true;

		return false;
	}

	private static boolean hasNull(Point[] points) {
		for (int i = 0; i < points.length; i++)
			if (points[i] == null)
				return true;
		return false;
	}

}