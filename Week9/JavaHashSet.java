package Week9;

import java.util.HashSet;
import java.util.Scanner;

public class JavaHashSet {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        HashSet<String> pairs = new HashSet<String>(size);
        String[] pair_left = new String[size];
        String[] pair_right = new String[size];

        for (int i = 0; i < size; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        for (int i = 0; i < size; i++) {
            pairs.add("(" + pair_left[i] + ", " + pair_right[i] + ")");
            System.out.println(pairs.size());
        }
        s.close();
    }
}
