import edu.princeton.cs.algs4.In;

public class Mergesort {
    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right;
        if (arr.length % 2 == 0) {
            right = new int[mid];
        } else {
            right = new int[mid + 1];
        }
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = arr[mid + j];
        }
        int[] rs = new int[arr.length];
        left = mergeSort(left);
        right = mergeSort(right);
        rs = merge(left, right);
        return rs;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] rs = new int[left.length + right.length];
        int lp, rp, rsp;
        lp = rp = rsp = 0;
        while (lp < left.length || rp < right.length) {
            if (lp < left.length && rp < right.length) {
                if (left[lp] < right[rp]) {
                    rs[rsp++] = left[lp++];
                } else {
                    rs[rsp++] = right[rp++];
                }
            } else if (lp < left.length) {
                rs[rsp++] = left[lp++];
            } else if (rp < right.length) {
                rs[rsp++] = right[rp++];
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        In in = new In("lib\\algs4-data\\8Kints.txt");
        int[] arr = in.readAllInts();
        int m = arr.length;
        long start = System.currentTimeMillis();
        arr = mergeSort(arr);
        long end = System.currentTimeMillis();
        printArr(arr);
        // System.out.println();
        System.out.println(end - start);
    }
}