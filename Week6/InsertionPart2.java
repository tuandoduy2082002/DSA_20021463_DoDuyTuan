import java.util.Arrays;
import java.util.Collections;

public class InsertionPart2 {
    static void insertionSort2(int n, int[] arr) {
        for (int i = 2; i <= n; i++) {
            insertionSort1(i, arr);
        }
    }

    private static void insertionSort1(int n, int[] arr) {
        int last = arr[n - 1], i = n - 2;
        while (i >= 0 && last < arr[i]) {
            arr[i + 1] = arr[i];
            printArray(arr);
            i--;
        }
        arr[i + 1] = last;
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        System.out.println(String.join(" ", Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new)));
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 3, 5, 6, 2 };
        insertionSort1(6, arr);
        printArray(arr);
        System.out.println(System.currentTimeMillis());
    }
}