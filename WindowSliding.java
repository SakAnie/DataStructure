import java.util.HashMap;

public class WindowSliding {

	public static void main(String[] args) {
		// Count Distinct elements in every window of SIZE K ina GIVEN LIST OF Numbers

		int[] a = { 1, 2, 3, 1, 2, 4, 5, 5, 8, 1, 2, 3 };
		int k = 4;

		/*
		 * For Example: Size: K =4 i/p:1,2,3,1=>o/p:3 2,4,5,5=>3 8,1,2,3=>3
		 */
		/*
		 * We will use Map concept here we will store each of those elements in a
		 * HashMap as Key and its frequency as Value
		 */

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		// Handle first K elements separately- "find the count of Distinct elements in
		// the first K items"
		for (int j = 0; j < k; j++) {

			/*
			 * if a[i] is present in the KeySet() of map, then increase count by 1, if a[i]
			 * is not present/null, then set the frequency to 0
			 */
			map.put(a[j], map.getOrDefault(a[j], 0) + 1);

		}
		System.out.println(map.size());

		// Handle from index =K to a.length
		for (int i = k; i < a.length; i++) {

			// if a[i-k] frequency is > 1 , then substract 1 from its existing frequncy part , else
			// if =1, then remove a[i-k]
			if (map.get(a[i - k]) == 1) {
				map.remove(a[i - k]);
			} else {
				map.put(a[i-k], map.get(a[i-k]) - 1); // window slide
			}
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);//keep on adding further elements to the map
			System.out.println(map.size());
		}

	}

}
