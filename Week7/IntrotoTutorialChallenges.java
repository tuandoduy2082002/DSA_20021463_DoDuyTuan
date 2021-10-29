package Week7;

import java.util.List;

public class IntrotoTutorialChallenges {
	public static int introTutorial(int target, List<Integer> nums) {
		int pivot, left = 0, right = nums.size() - 1;
		while (left <= right) {
			pivot = left + (right - left) / 2;
			if (nums.get(pivot) == target)
				return pivot;
			if (target < nums.get(pivot))
				right = pivot - 1;
			else
				left = pivot + 1;
		}
		return -1;
	}
}
