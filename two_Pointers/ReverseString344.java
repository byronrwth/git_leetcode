package two_Pointers;

public class ReverseString344 {
/*
 * Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
 * */
	public static String reverseString(String s) {
		String reverse = "";
		int end = s.length()-1;
		int mid = s.length()/2; // e.g [0~0=(2/2-1)] [1(2/2)~1(2-1)]
		String first="", second= "";
		
        if (s == null || s.length() == 0) {
            return reverse;
        }
        if (s.length() == 1) {
        	return s;
        }
        
		//System.out.println("len= " + s.length() + " , end= " + end + " , mid= " + mid + "\n");
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
		//System.out.println("second= " + second);
		
		reverse = reverseString(second) + reverseString(first);
		//System.out.println("reverse= " + reverse);
		
		return reverse; 
				
//		for( ;  end >= 0; end--) {
//			System.out.println( s.substring( end  , end+1 ) );
//			reverse += s.substring( end  , end+1 );
//			//System.out.println( reverse );
//		}
		
//		return reverse ; 
	}
	
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( reverseString(" 123sdfeg 123 edrf ") );
	}

}
