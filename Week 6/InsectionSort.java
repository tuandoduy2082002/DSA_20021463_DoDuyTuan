import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class InsectionSort {
    public static void insertionsort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        In in = new In("lib\\algs4-data\\samevalue.txt");
        int[] a = in.readAllInts();
        // int [] a = {1,2,3,4,5,6,7,8,9,10};
        // System.out.println("helo");
        // long start = System.currentTimeMillis();
        // xử lý dữ liệu trong mảng a
        insertionsort(a);
        System.out.println(System.currentTimeMillis());
        // long end = System.currentTimeMillis(); // thời gian chạy bằng end - start
        // System.out.println(end - start);
        StdArrayIO.print(a); // in mảng ra màn hình

    }
}