package String;

import java.util.Arrays;

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
    static public boolean anagram(String s, String t) {
        if ( s.length() == 0 || t.length() == 0 ) {
        	return false;
        }
        
        
        if ( s.length() != t.length() ) {
        	return false;
        }
        
        char[] orderchar1 = s.toCharArray() ;
        Arrays.sort(orderchar1);
        
        char[] orderchar2 = t.toCharArray() ;
        Arrays.sort(orderchar2);
        
        if (Arrays.equals(orderchar1, orderchar2)) {
        	return true;
        }else {
        	return false;
        }
        
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcd";
		String t = "dcab";
		String[] strs = {"","","a","ab","ba"};
		System.out.println(s
				);
		//System.out.println( "anagram = " + anagram(s,  t ));
	}

}
