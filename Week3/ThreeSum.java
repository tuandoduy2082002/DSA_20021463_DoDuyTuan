import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class ThreeSum {

    // O(n^2)
    public static void threeSum(int[] num) {
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int low = i + 1, high = num.length - 1, sum = 0 - num[i];
                while (low < high) {
                    if (num[low] + num[high] == sum) {
                        System.out.println(num[i] + " " + num[low] + " " + num[high]);
                        while (low < high && num[low] == num[low + 1])
                            low++;
                        while (low < high && num[high] == num[high - 1])
                            high--;
                        low++;
                        high--;
                    } else if (num[low] + num[high] < sum)
                        low++;
                    else
                        high--;
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
