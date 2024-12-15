import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class twosumFindIndex {

	public static void main(String[] args) {

		int[] A = { 2, 3, 4, 5, 6, 7, 8, 9, 1 };
		int low = -1;
		int high = -1;
		int key_sum = 10;
		int curr_sum = 0;
		int size = A.length;

		LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<Integer, Integer>();
		// in Key part store the ARRAY value and the value part , store the Array INDEX

		for (int i = 0; i < size; i++) {

			hm.put(A[i], i);

			if (hm.containsKey(key_sum - A[i])&& A[i]!=key_sum-A[i]){
				
				//assuming array does not contain duplicates
				System.out.println("indexes are" + hm.get(A[i]) + "and" + hm.get(key_sum - A[i]));
			}

		}

	}

}
---- LEETCODE-----
	import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a map to store numbers and their indices
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        // Iterate through the array to find the two numbers
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];  // Current number in the array
            int complement = target - currentNum;  // The number needed to reach the target

            // Check if the complement is already in the map
            if (hm.containsKey(complement)) {
                // If complement found, return the indices of the two numbers
                return new int[] { hm.get(complement), i };
            }

            // If complement not found, store the current number and its index in the map
            hm.put(currentNum, i);
        }
        
        // If no solution is found (though the problem guarantees one)
        return new int[] {-1, -1};
    }
}
