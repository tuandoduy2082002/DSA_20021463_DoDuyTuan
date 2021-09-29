import java.util.List;
import java.util.Arrays;

public class SherlockAndArray {
    public static String balancedSums(List<Integer> arr) {
        int sumLeft = 0, sumRight = 0;
        for (int i = 0; i < arr.size(); i++)
            sumRight += arr.get(i); // 8
        if (sumLeft == sumRight - arr.get(0))
            return "YES";
        else
            sumRight -= arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (sumLeft == sumRight)
                return "YES";
            sumLeft += arr.get(i - 1);
            sumRight -= arr.get(i);
        }
        return "NO";
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[] { 1, 2, 8, 100, 9, 2 };
        List<Integer> arr = Arrays.asList(nums);
        System.out.println(balancedSums(arr));
    }
}
