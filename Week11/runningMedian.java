package Week11;

import java.util.*;

public class Pairs {

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> result = new ArrayList<>();
        PriorityQueue<Double> minHeap = new PriorityQueue<>();
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (double v : a) {
            if (maxHeap.isEmpty() || (v < maxHeap.peek())) {
                maxHeap.offer(v);
            } else {
                minHeap.offer(v);
            }

            if (maxHeap.size() > (minHeap.size() + 1)) {
                minHeap.offer(maxHeap.poll());
            }

            if (minHeap.size() > (maxHeap.size() + 1)) {
                maxHeap.offer(minHeap.poll());
            }

            if (maxHeap.size() > minHeap.size()) {
                result.add(maxHeap.peek());
            } else if (minHeap.size() > maxHeap.size()) {
                result.add(minHeap.peek());
            } else {
                result.add(0.5 * (minHeap.peek() + maxHeap.peek()));
            }
        }
        return result;
    }
}