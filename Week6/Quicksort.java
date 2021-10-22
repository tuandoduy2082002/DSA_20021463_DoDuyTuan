import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdArrayIO;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Quicksort {
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length-1);
    }
    private static void quickSort(int[] a, int low, int high) {
        if(low < high + 1) {
            int p = partition(a, low, high);
            quickSort(a, low, p -1);
            quickSort(a, p+1, high);
        }
    }
    private static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    private static int getPivot(int low, int high) {
        Random rand = new Random();
        return rand.nextInt((high-low) + 1) + low;
    }

    private static int partition(int[] a, int low, int high) {
        swap(a, low, getPivot(low, high));
        int border = low +1 ;
        for(int i = border; i <= high; i++) {
            if(a[i] < a[low]) {
                swap(a, i, border++);
            }
        }
        swap(a, low, border-1);
        return border-1;
    }

    public static void main(String[] args) {
        int n ;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0 ; i < n ; i++) {
            a[i] = ThreadLocalRandom.current().nextInt();
        }
        long start = System.currentTimeMillis();
        quickSort(a);
        System.out.println(System.currentTimeMillis());
        long end = System.currentTimeMillis();
        System.out.println(end);
        for(int i = 0 ; i < n ; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println(end-start);
//        In in = new In("lib\\algs4-data\\samevalue.txt");
//        int[] a = in.readAllInts();
//        int [] a = {1,2,3,4,5,6,7,8,9,10};
//        System.out.println("helo");
//        long start = System.currentTimeMillis();
        // xử lý dữ liệu trong mảng a
//        quickSort(a);
//        System.out.println(System.currentTimeMillis());
//        long end = System.currentTimeMillis();  // thời gian chạy bằng end - start
//        System.out.println(end - start);
//        StdArrayIO.print(a); // in mảng ra màn hình
    }
}