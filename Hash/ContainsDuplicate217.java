package Hash;

import java.util.HashMap;

public class ContainsDuplicate217 {

	static HashMap<Integer, Integer> myHashMap = new HashMap<Integer, Integer>();
	
    static public boolean containsDuplicate(int[] nums) {
        if (nums==null || nums.length == 0) {
        	return false;
        }
        
        for (int i = 0; i<nums.length ;i++) {
        	if ( myHashMap.containsKey( nums[i] ) ==true ) {
        		return true;
        	}
        	
        	myHashMap.put(nums[i], i);
        }
        
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println( containsDuplicate( nums ) );
	}
}
