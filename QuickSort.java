package algorithm;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] A = new int[]{5, 6, 1, 4, 3, 7, 9, 10};
		
		QuickSort q = new QuickSort();
		q.quickSort(A);
		
		for (int i: A)
			System.out.println(i + " ");
	}
	
	public void quickSort(int[] A) {
		if (A == null || A.length < 2)
			return;
		helper(A, 0, A.length-1);
	}
	
	public void helper(int[] A, int low, int high) {
		// the base case
		if (A == null || A.length < 2)
			return;
	
		int i = low, j = high;
		int pivot = (low + high) / 2 ;
		while (i <= j) {
			while (A[i] < A[pivot])
				i++;
			while (A[j] > A[pivot])
				j--;
			
			if (i <= j) {
				swap(A, i, j);
				i++;
				j--;
			}
		}
		
		if (low < j)
			helper(A, low, j);
		if (high > i)
			helper(A, i, high);
	}
	
	public void swap(int[] A, int i, int j) {
		int t = A[i];
		A[i] = A[j];
		A[j] = t;
	}
}
