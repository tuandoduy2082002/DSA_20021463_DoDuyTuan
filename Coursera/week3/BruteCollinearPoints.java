package week3;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

	private ArrayList<LineSegment> segmentStack = new ArrayList<>();

	public BruteCollinearPoints(Point[] points) {

		if (points == null || hasDuplicate(points) || hasNull(points))
			throw new IllegalArgumentException(); 
		
		Point[] copy = points.clone();
		Arrays.sort(copy);

		for (int first = 0; first < copy.length - 3; first++)
			for (int second = first + 1; second < copy.length - 2; second++) {
				double slopeFS = copy[first].slopeTo(copy[second]);
				for (int third = second + 1; third < copy.length - 1; third++) {
					double slopeFT = copy[first].slopeTo(copy[third]);
					if (slopeFS == slopeFT) {
						for (int forth = third + 1; forth < copy.length; forth++) {
							double slopeFF = copy[first].slopeTo(copy[forth]);
							if (slopeFS == slopeFF)
								segmentStack.add(new LineSegment(copy[first], copy[forth]));
						}
					}
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
		for (Point point : points)
			if (point == null)
				return true;
		return false;
	}
}