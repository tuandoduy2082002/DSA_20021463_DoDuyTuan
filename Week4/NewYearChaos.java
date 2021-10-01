import java.util.List;

public class NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
        int swapCount = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    swapCount++;
                }
            }
        }
        System.out.println(swapCount);
    }
}
