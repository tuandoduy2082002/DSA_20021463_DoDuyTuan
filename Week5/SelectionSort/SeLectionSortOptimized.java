package Week5.SelectionSort;

public class SeLectionSortOptimized {
	// O(n)
	
	public static void swap(int arr[], int a,int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public void sort(int arr[]) {
		int n = arr.length;

		int start = 0;
		int end = n -1;
		while(start < end) {
			int smallest = start;
			int largest = start;
			int max = arr[largest];
			
			for (int i=start+1;i<=end;i++) {
				if (arr[i] < arr[smallest] ) {
					smallest = i;
				}
				if (arr[i] > arr[max]) {
					largest = i;
					max = arr[i];
				}
			}
			swap(arr,start,smallest);
			if(arr[smallest] == max) 
				swap(arr,end,smallest);
			else
				swap(arr,end,largest);
			start++;
			end--;
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
