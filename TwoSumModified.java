import java.util.HashSet;

public class TwoSumModified {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 4, 9 };
		int key = 8;
		// Find all such set of 3 numbers in this array whose sum is equal to a given
		// KEY: 6
		// a[i]+a[j]=key
		// Find solution in O(n)

		HashSet hs = new HashSet();
		for (int i = 0; i < a.length; i++) {

			// CORE LOGIC: IF THE HASHSET CONTAINS a[j] ( ie key-a[i])=> then print the pair
			// Two Sum - Pairs
			if (hs.contains(key - a[i])) {
				System.out.println("triplet is " + a[i] + " " + " & " + (key - a[i]));
			}
			hs.add(a[i]); // add the items to the HashSet

		}
	}
}
