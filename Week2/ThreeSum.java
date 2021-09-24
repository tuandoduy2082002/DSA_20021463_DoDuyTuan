import edu.princeton.cs.algs4.*;

public class ThreeSum {
    public static void threeSum(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; j < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        In in = new In("D:\\DSA-JAVA\\algs4-data\\4Kints.txt"); // tạo luồng đọc từ file
        int[] a = in.readAllInts(); // đọc toàn bộ file vào mảng a
        StdArrayIO.print(a); // in mảng ra màn hình
        threeSum(a);
    }
}
