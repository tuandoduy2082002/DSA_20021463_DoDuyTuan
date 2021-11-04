package Week8;

import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        String s = sc.next();
        int a = s.length()-1;
        String ans = "Yes";
        for (int i = 0; i < a/2; i++) {
            if (s.charAt(i) != s.charAt(a-i)) {
                ans = "No";
                break;
            }
        }
        System.out.println(ans);
    }
}
