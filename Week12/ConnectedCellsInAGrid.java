package Week11;

import java.util.*;

public class Pairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int rs(int[][] matrix , int i , int j){
        if(i<0 || j<0 || i >= matrix.length || j >= matrix[i].length)
            return 0;
        if(matrix[i][j] == 0)
            return 0;
        int size = 1;
        matrix[i][j] = 0;
        for(int r = i-1; r<=i+1;r++){
            for(int c = j-1; c <= j+1; c++){
                if(r != i || c != j){
                    size += rs(matrix,r,c);
                }
            }
        }
        return size;
    }

    static int connectedCell(int[][] matrix,int n , int m ) {
        int max = 0;
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(matrix[i][j] == 1){
                    int size = rs(matrix , i ,j);
                    max = Math.max(size , max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matrix[i][j] = in.nextInt();
            }
        }
        int result = connectedCell(matrix,n,m);
        System.out.println(result);
        in.close();
    }
}
        int k = scanner.nextInt();
        int counter = 0;
        Set<Integer> nums = new HashSet<Integer>();
        for (int i =0; i < n; i++) {
            int m = scanner.nextInt();
            if (nums.contains(m-k))
                counter++;
            if (nums.contains(m+k))
                counter++;
            nums.add(m);
        }
        System.out.println(counter);
    }
}