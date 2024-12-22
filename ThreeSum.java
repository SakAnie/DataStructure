--LEETCODE THREESOME---VERY VERY IMP----------
    ---- Here number of elements fixed is 1 which is nums[i], so the way to remove the duplicates of nums[i] which just as 'array elem' is this:
      // Skip duplicates for the first element of the triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

  ---- However j acts like a 'pointer' so way to remove duplicate elements of nums[j] is
      // Step5:Skip duplicates for the second element (nums[j]) to avoid repeating triplets
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        j++;
                    }

-----------------------SOLUTION STARS HERE--------------
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step1: Sort the array to handle duplicates and simplify triplet checking
        Arrays.sort(nums);
        
        // Step2:Iterate through the array to pick the first element of the triplet
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element of the triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Step3:Use a HashMap to find the complement for the second and third elements
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int target = -(nums[i] + nums[j]);  // The complement we're looking for
                
                // Step4:If the complement exists in the map, we have found a triplet
                if (map.containsKey(target)) {
                    result.add(Arrays.asList(nums[i], nums[j], target));
                    
                    // Step5:Skip duplicates for the second element (nums[j]) to avoid repeating triplets
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        j++;
                    }
                }
                
                // Step6:Add the current number (nums[j]) to the map
                map.put(nums[j], j);
            }
            
            // Step7: Skip duplicates for the first element (nums[i]) to avoid repeating triplets
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        
        return result;
    }
}
