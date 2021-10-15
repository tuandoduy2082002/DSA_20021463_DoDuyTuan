package Week5.SelectionSort;

public class SelectionSort {
	public void sort(int arr[]) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			// Swap min element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}
	
	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort();
		int arr[] = {4,5,6,7,32,534,3,23,534,435,13,1231,3543,41,3452,5445,1324321,52431,1,2,3,4,5,6,4145,4532};
		selectionSort.sort(arr);
		for (var a : arr) 
			System.out.println(a);
		//run something that takes time
	      System.out.println(System.currentTimeMillis());

	}
}
