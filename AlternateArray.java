package GeeksforGeeks;

public class AlternateArray {
	public static void main(String[] args) {

		int[] arr = { 1, 3, 5, 6, 8, 9, 10 };// Given sorted array

		/*
		 * 
		 * o/p: 10,1,9,3,8,5,6 <1st max,1stmin,2ndmax,2ndmin,3rdmax,3rdmin,....> long
		 * me=arr[n-1]+1; int max=n-1; int min=0;
		 * 
		 * for(int i=0;i<n;i++) {
		 * 
		 * //Store two elements in the same array concept if(i%2==0){
		 * arr[i]=arr[i]+(arr[max--]%me) * me; } else{ arr[i]=arr[i]+(arr[min++]%me) *
		 * me; } //the result array elem when %me ==>original array //the result array
		 * elem when /me ==> the required alternate array
		 * 
		 * } for(int i=0;i<n;i++){ arr[i]=arr[i]/me; }
		 * 
		 */

		int n = arr.length;
		int max_index = n - 1;
		int min_index = 0;
		int me = arr[n - 1] + 1; // Special quotiont me which is max_value + 1

		for (int i = 0; i < n; i++) {
			// Traverse the array and provide conditions of even index elements and odd
			// index elements
			// FORMULAE for index=even
			if (i % 2 == 0) {
				//Even
				arr[i] = arr[i] + (arr[max_index--] % me) * me;
			} else {
				//ODD
				arr[i] = arr[i] + (arr[min_index++] % me) * me;
			}

		}

		// Now, We have a modified array with different set of elements when /me ==> required

		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] / me;
		}

		for (int x : arr) {
			System.out.print(x);
		}
	}

}
