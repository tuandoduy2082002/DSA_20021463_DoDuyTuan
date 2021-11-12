package Week9;

import java.util.List;

public class closestNumbers {
    // find the pair of elements that have the smallest absolute difference between
    // them using merge sort
    public List<Integer> solve(List<Integer> arr) {

        // convert list integer to array int[].
        int[] arrInt = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            arrInt[i] = arr.get(i);
        }
        // sort array using merge sort.
        Week6.MergeSort.mergeSort(arrInt, 0, arrInt.length - 1);

        // find a list of smallest absolute difference between two elements.
        int minDiff = Integer.MAX_VALUE;
        List<Integer> result = new java.util.ArrayList<>();
        for (int i = 0; i < arrInt.length - 1; i++) {
            int diff = Math.abs(arrInt[i] - arrInt[i + 1]);
            if (diff < minDiff) {
                minDiff = diff;
                result.clear();
                result.add(arrInt[i]);
                result.add(arrInt[i + 1]);
            } else if (diff == minDiff) {
                result.add(arrInt[i]);
                result.add(arrInt[i + 1]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // create an instance of closest numbers from n.
        closestNumbers closestNumbers = new closestNumbers();
        // create an array of integers with n size.
        List<Integer> arr = List.of(-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854,
                -520, -470);
        // print the result.
        System.out.println(closestNumbers.solve(arr));
    }
}
