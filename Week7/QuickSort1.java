package Week7;

import java.util.ArrayList;
import java.util.List;

public class QuickSort1 {
	public static List<Integer> quickSort(List<Integer> arr) {
		// Write your code here
		int pivot = arr.get(0);
		int n = arr.size();
		List<Integer> equal = new ArrayList<Integer>();
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (arr.get(i) == pivot) {
				equal.add(arr.get(i));
			} else if (arr.get(i) < pivot) {
				left.add(arr.get(i));
			} else if (arr.get(i) > pivot) {
				right.add(arr.get(i));
			}
		}
		left.addAll(equal);
		left.addAll(right);
		List<Integer> ans = new ArrayList<Integer>(left);
		return ans;
	}
}
