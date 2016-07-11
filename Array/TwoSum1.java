package Array;

import java.util.HashMap;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.
 * */
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
        	return null ;
        }
        int[] result; 
        
        
        HashMap<Integer , Integer> myMap = new HashMap<Integer , Integer >() ;
            
        int index = 0, index1 = 0, index2 = 0;     
        while ( index < nums.length) {
        	if (myMap.containsKey(target - nums[index])) {
        	    // now this pair {numbers[index], target - numbers[index] } can be found , which sum is target
        		if ( index >= myMap.get(target - nums[index]) ) {
        			index1 = myMap.get(target - nums[index]) ;
        			index2 = index ;
        		}
        		else {
        			index1 = index ;
        			index2 = myMap.get(target - nums[index]) ; 
                }
        		return new int[] {index1, index2 } ;
        	}
    		else {
    			myMap.put(nums[index], index) ; 
    			index++;
    		}
        	
        }
        return null ;            
            
    }
}
