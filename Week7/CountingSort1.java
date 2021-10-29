package Week7;

import java.util.ArrayList;
import java.util.List;

public class CountingSort1 {
	public static List<Integer> countingSort(List<Integer> arr) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			ans.add(0);
		}
		for (Integer integer : arr) {
			ans.set(integer, ans.get(integer) + 1);
		}
		return ans;
	}
}
