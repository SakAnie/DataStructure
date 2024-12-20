import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<Integer, Integer>();
	// to save space!! since its two sum
        int[] keysetArray=new int[2]; 
      
        for (int i = 0; i < nums.length; i++) {
                	

			if (hm.containsKey(target - nums[i])){

                keysetArray[0]=i;
                keysetArray[1]=hm.get(target-nums[i]);

                for (int x : keysetArray) 
                    System.out.println(x);
        
            }
            hm.put(nums[i], i);//must add after the logic not before!!!!
        
        

        
        } 
        return keysetArray;
    }
}
