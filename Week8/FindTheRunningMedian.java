package Week8;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
        	
        	int n = in.nextInt();
        	
        	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        	
        	for (int i = 0; i < n; ++i) {
        		int v = in.nextInt();
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
        			System.out.println(maxHeap.peek());
        		} else if (minHeap.size() > maxHeap.size()) {
        			System.out.println(minHeap.peek());
        		} else {
        			System.out.println(0.5 * (minHeap.peek() + maxHeap.peek()));
        		}
        	}
        	
        }
    }
}