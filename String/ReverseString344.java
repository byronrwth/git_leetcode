package String;

/*Write a function that takes a 
 * string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
 * */
public class ReverseString344 {
public String reverseString(String s) {
        
        String reverse = "";
        
        if (s == null || s.length() == 0) {
            return reverse;
        }
        if (s.length() == 1) {
        	return s;
        }
        
		int end = s.length()-1;
		int mid = s.length()/2;
		String first="", second= "";
		
		if ( mid >= 0) {
			 first = s.substring(0, mid); // 0 ~ mid-1
		}
		else {
			 first = s.substring(0);
		}
		//System.out.println("first= " + first);
		if ( end+1 >= mid) {
			 second = s.substring( mid, end+1);  //mid ~ end
		}
		else {
			 second = s.substring( mid);
		}
		
		
		reverse = reverseString(second) + reverseString(first);
		return reverse;
	}
}
