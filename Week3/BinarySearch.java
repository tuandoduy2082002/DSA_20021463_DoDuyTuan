import java.util.Arrays;

public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int nums[] = { 4, 5, 6, 8, 9, 10, 15, 1, 2, 3 };
        Arrays.sort(nums);
        int target = 8;
        int result = bs.binarySearch(nums, target);
        System.out.println(result);
    }
}
