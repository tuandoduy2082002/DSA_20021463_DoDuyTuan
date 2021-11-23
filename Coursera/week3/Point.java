package week3;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw() {
		StdDraw.point(x, y);
	}

	public void drawTo(Point that) {
		StdDraw.line(this.x, this.y, that.x, that.y);
	}

	public double slopeTo(Point that) {
		double xdif = that.x - this.x;
		double ydif = that.y - this.y;

		if (xdif == 0 && ydif == 0)
			return Double.NEGATIVE_INFINITY;
		else if (xdif == 0)
			return Double.POSITIVE_INFINITY;
		else if (ydif == 0)
			return +0.0;
		else {
			return ydif / xdif;
		}

	}

	public int compareTo(Point that) {
		if (this.y < that.y)
			return -1;
		else if (this.y == that.y && this.x == that.x)
			return 0;
		else if (this.y == that.y && this.x < that.x)
			return -1;
		else
			return +1;

	}

	public Comparator<Point> slopeOrder() {
		return new SlopeOrder();
	}

	private class SlopeOrder implements Comparator<Point> {
		public int compare(Point p1, Point p2) {
			double a = Point.this.slopeTo(p1);
			double b = Point.this.slopeTo(p2);

			return Double.compare(a, b);
		}
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public static void main(String[] args) {
		Point p5 = new Point(20000, 21000);
		Point p6 = new Point(3000, 4000);
		Point p7 = new Point(14000, 15000);
		Point p8 = new Point(6000, 7000);
		System.out.println(p6.slopeTo(p8));
		System.out.println(p6.slopeTo(p7));
		System.out.println(p6.slopeTo(p5));
	}
}