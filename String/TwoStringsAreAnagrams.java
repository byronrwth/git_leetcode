package String;
/*
 * Write a method anagram(s,t) to decide if two strings are anagrams or not.

Have you met this question in a real interview? Yes
Clarification
What is Anagram?
- Two strings are anagram if they can be the same after change the order of characters.

Example
Given s = "abcd", t = "dcab", return true.
Given s = "ab", t = "ab", return true.
Given s = "ab", t = "ac", return false.
 * */
public class TwoStringsAreAnagrams {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        if ( s.length() == 0 || t.length() == 0 ) {
        	return false;
        }
        
        if ( s.length() != t.length() ) {
        	return false;
        }
        
        int[] letterCount = new int[256] ;
        
        for (int i = 0; i< s.length();i++) {
        	letterCount[i]
        }
        
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
