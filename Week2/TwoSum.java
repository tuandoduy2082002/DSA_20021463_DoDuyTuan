import edu.princeton.cs.algs4.*;

public class TwoSum {
    // for for O(n^2)
    public static void twoSum(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == 0)
                    System.out.println(nums[i] + " " + nums[j]);
            }
        }
    }

    public static void main(String[] args) {
        In in = new In("D:\\DSA-JAVA\\algs4-data\\4Kints.txt"); // tạo luồng đọc từ file
        int[] a = in.readAllInts(); // đọc toàn bộ file vào mảng a
        StdArrayIO.print(a); // in mảng ra màn hình
        twoSum(a);
    }
}
