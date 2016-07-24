package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 * */
public class GroupAnagrams49 {
    
	static HashMap<String, List<String>> mymap = new HashMap<String, List<String>>();
	
	static public List<List<String>> groupAnagrams(String[] strs) {
		if ( strs == null || strs.length==0) {
			return null;
		}
		
		List<List<String>> result = new ArrayList<List<String>>(); 
		
		char[] ordered = null;
		List<String> empty= new ArrayList<String>();
		
		for(String str: strs) {
		    if (str.length() == 0) {  // str = ""
		    	empty.add("");

		        continue;
		    }
		    
			//reorder each string in alphabetic order, therefore "eat", "tea" will be recognized as the same character array
			ordered = str.toCharArray() ;
			Arrays.sort(ordered);
			
			String strSorted = String.valueOf(ordered);
			
			if (mymap.containsKey(strSorted)) {
				mymap.get(strSorted).add(str); // i.e. ["ate"] add "eat" to be ["ate", "eat"]
				
				// check whether need update with mymap.put(strSorted,  alist)
				System.out.println( mymap.get(strSorted).indexOf(str) );
			}
			else {
				List<String> alist = new ArrayList<String>();
				alist.add(str);
				mymap.put(strSorted, alist); 
			}
	        
		}

		if (empty.size() >0 ) {
			result.add(empty);
		}
		for (String key : mymap.keySet()) {
			result.add(mymap.get(key));
		}
		
		return result;
    }
    
	public static void main(String[] args) {
		String[] strs = {"","","a","ab","ba"};
		System.out.println( groupAnagrams( strs ));
	}

}
