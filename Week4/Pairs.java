import java.util.*;

public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
        Collections.sort(arr);
        int left = 0, right = 1;
        int res = 0;
        while (right < arr.size()) {
            int diff = arr.get(right) - arr.get(left);
            if (diff == k) {
                res++;
                right++;
            }
            if (diff > k)
                left++;
            if (diff < k)
                right++;
        }
        return res;
    }
}
