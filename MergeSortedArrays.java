package GeeksforGeeks;

public class MergeSortedArrays {

	public static void main(String[] args) {

		/*
		 * 
		 * input arrays given a1 & a2
		 * 
		 * 
		 */
		int[] a1 = { 5, 6, 7, 8 };
		int[] a2 = { 0, 1, 2, 3, 9, 10, 15 };

		/*
		 * 
		 * 3 STEPS with Space O(1):-
		 * 
		 * Step1: compare the first elements of both the arrays
		 * 	      whichever is smaller should stay in the first array , otherwise swap
		 * step2: if swap has happened, then check whether a2 is still sorted or not
		 *        if not, then run fixarray(arr[]) method, it basically swaps the adjacent elements, since we know a2 is also sorted only , 
		 * 	      so just adjacent elements needs to be sorted
		 * step3: then increment the i counter of the arr1.
		 * 
		 */

//without extra space
		int i = 0;
		int j = 0;
		int temp = 0;
		while (i < a1.length) {

			// compare the first elements of both the arrays
			if (a1[i] > a2[j]) {
				// Swap
				temp = a1[i];
				a1[i] = a2[j];
				a2[j] = temp;
				// check if the a2 array after the swap is still sorted or not
				fixArray2(a2);

			}
			i++;

		}

		for (int x : a1) {
			System.out.print(x);
		}
		System.out.print("         ");
		for (int y : a2) {

			System.out.print(" " + y);
		}

	}
	
	public static void fixArray2(int[] a2) {
		int temp=0;
		for(int j=0;j<a2.length-1;j++) {
			if(a2[j]>a2[j+1]) {
				temp=a2[j];
				a2[j]=a2[j+1];
				a2[j+1]=temp;
				
			}
		}
		
	}

}
