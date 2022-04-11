
public class QuickSort {

	public static void quicksort(int[] array, int low, int high) {

		if (low >= high) {
			return;
		}

		// 3 STEPS: Find Pivot, divide into LEFT and ARRAY SUB ARRAY , apply quicksort
		// recursively

		// STEP1:Find the Pivot
		int pivot = array[high];

		// STEP2: PARTITIONING

		int leftpointer = low;
		int rightpointer = high;

		while (leftpointer < rightpointer) {

			// walk lp from LEFT TO RIGHT until we find a number which is > pivot

			// walk RP from RIGHT to LEFT until we find a number which is < pivot

			while (array[leftpointer] <= pivot && leftpointer < rightpointer) {
				leftpointer++;
			}
			while (array[rightpointer] >= pivot && rightpointer > leftpointer) {
				rightpointer--;
			}

			swap(array, leftpointer, rightpointer);

		}
		swap(array, leftpointer, high);

		quicksort(array, low, leftpointer - 1);
		quicksort(array, leftpointer + 1, high);
	}

	public static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	public static void main(String[] args) {

		QuickSort q = new QuickSort();
		int[] a = { 2, 5, 4, 3, 1, 9, 8, 0 };
		q.quicksort(a, 0, a.length - 1);

		for (int x : a) {
			System.out.println(x);
		}

	}

}
