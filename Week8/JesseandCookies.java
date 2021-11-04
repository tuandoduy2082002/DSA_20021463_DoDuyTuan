package Week8;

import java.util.*;

public class JesseandCookies {
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int operation = 0;
        for (int key : A) {
            minheap.add(key);
        }
        while(minheap.size() > 1) {
            if(minheap.peek() >= k) {
                return operation;
            } else {
                int cookie1 = minheap.poll();
                int cookie2 = minheap.poll();
                int newCookie = cookie1 + cookie2 * 2;
                minheap.add(newCookie);
                operation++;
            }
        }
        if(minheap.size() > 0 && minheap.peek() >= k) {
            return operation;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> pqueue = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pqueue.add(sc.nextInt());
        }
        int result = cookies(k, pqueue);
        System.out.println(result);
    }
}
