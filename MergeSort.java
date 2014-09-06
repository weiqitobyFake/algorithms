package algorithms;

public class MergeSort {
	
	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		
		int[] A = new int[]{-4, 0, 1, 5, -2, 6, 7, 13};
		
		m.mergeSort(A);
		for (int i: A)
			System.out.print(i + " ");
	}
	
	public int[] mergeSort(int[] A) {
		if (A == null || A.length < 2)
			return A;

		int[] temp = new int[A.length];
		
		recurse(A, 0, A.length-1,temp);
		return A;
	}
	
	public void recurse(int[] A, int low, int high, int[] temp) {
		if (low == high)
			return;
		
		int m = (low + high) / 2;
		
		recurse(A, low, m, temp);
		recurse(A, m+1, high, temp);
		
		doMerge(A, low, m, high, temp);
		
	} 
	
	public void doMerge(int[] A, int low, int m, int high, int[] temp) {
		
		for (int index = low; index <= high; index++) {
			temp[index] = A[index];
		}
		
		int i=low, j=m+1, p=low;
		
		while (i <= m && j<=high) {
			if (temp[i] <= temp[j]) {
				A[p++]=temp[i++];
			}else
				A[p++]=temp[j++];
		}
		
		while (i <= m) {
			A[p++] = temp[i++]; 
		}
	}
	
}
