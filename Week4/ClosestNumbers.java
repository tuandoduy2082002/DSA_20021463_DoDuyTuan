import java.util.*;

public class ClosestNumbers {
    public static List<Integer> closestNumbers(List<Integer> arr) {
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) - arr.get(i - 1) < min) {
                min = arr.get(i) - arr.get(i - 1);
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) - arr.get(i - 1) == min) {
                result.add(arr.get(i - 1));
                result.add(arr.get(i));
            }
        }
        return result;
    }
}
