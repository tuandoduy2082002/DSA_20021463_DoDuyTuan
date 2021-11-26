package Week11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class MissingNumbers {
	
	//Approach 1: Hash -> O(a + b) time and O(b) space.
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
    	Hashtable<Integer, Integer> ht = new Hashtable<>();

        // Add elements of original list
        for (int i : brr) {
            int freq = ht.getOrDefault(i, 0);
            freq++;
            ht.put(i, freq);
        }

        // Remove elements of new list
        for (int i : arr) {
            int freq = ht.get(i);
            freq--;
            if (freq == 0)
                ht.remove(i);
            else
                ht.put(i, freq);
        }

        // Create the result array
        List<Integer> res = new ArrayList<>(ht.size());
        for (Map.Entry<Integer, Integer> e : ht.entrySet()) {
            res.add(e.getKey());
        }
        Collections.sort(res);
        return res;	
    }
    
    //Approach 2: couting sort
    public static List<Integer> missingNumbers2(List<Integer> arr, List<Integer> brr) {
        int[] check = new int[10000];
        int[] check2 = new int[10000];
        for (int i : arr) {
            check[i]++;
        }
        for (int i : brr) {
            check2[i]++;
        }
        List<Integer> miss = new ArrayList<>();
        for (int i = 0;i < 10000; i++) {
            if (check[i] != check2[i])
                miss.add(i);
        }
        return miss;
    }
}
