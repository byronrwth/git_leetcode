package Hash;

import java.util.HashMap;

public class ContainsDuplicate217 {

	static HashMap<Integer, Integer> myHashMap = new HashMap<Integer, Integer>();
	
    static public boolean containsDuplicate(int[] nums) {
        if (nums==null || nums.length == 0) {
        	return false;
        }
        
        for (int i = 0; i<nums.length ;i++) {
        	if ( myHashMap.containsKey( nums[i] ) == true ) {
        		System.out.println(" duplicate: " + nums[i]);
        		return true;
        	}
        	
        	myHashMap.put(nums[i], i);
        }
        
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 3, 1 };
		//ArrayList<Integer> test = new ArrayList<Integer>( Arrays.asList(-2, 2, -3, 4,-1,2,1,-5,3) ) ;
		
		System.out.println( containsDuplicate( nums ) );
	}
}
