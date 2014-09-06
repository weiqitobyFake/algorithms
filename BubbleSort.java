package algorithms;

public class BubbleSort {
	public static void bubbleSort(int[] A) {
		if (A == null || A.length < 2)
			return;

		boolean doMore = true;
		while (doMore) {
			doMore = false;

			for (int i = 0; i < A.length - 1; i++) {
				if (A[i] > A[i + 1]) {
					swap(A, i, i + 1);
					doMore = true;
				}
			}
		}
	}

	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String[] args) {
		int[] A = new int[] { 5, 6, 1, 4, 3, 7, 9, 10 };

		// bubbleSort(A);
		BubbleSort b = new BubbleSort();

		for (int i : A)
			System.out.println(i + " ");
	}
}
