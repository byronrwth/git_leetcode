import java.io.BufferedInputStream;
/*import StdIn;
import StdOut;*/
import java.lang.*;
import java.util.*;

/*import StdIn;
import StdOut;*/



public class test66 {
    
    public test66() {
    }
    
    
/* 
    66. solution for plusOne.
*/   
//        Given a non-negative number represented as an array of digits, plus one to the number.
//        The digits are stored such that the most significant digit is at the head of the list.

//        public class Solution {
        public int[] plusOne(int[] digits) {
            int j = digits.length-1;
            int result = 0;
            for ( ; j >= 0 ; j--) {
                if (digits[j] >= 0 && digits[j] <= 8) {
                    digits[j] += 1;
                    break;
                }
                else if (digits[j] == 9){ 
                    digits[j] = 0;
                    
                    if (j == 0) {
                        int N = digits.length +1;
                        int[] larger = new int[N];
                        larger[0] = 1;
                        for ( int i = 1; i <larger.length; i++  ) {
                            larger[i] = 0;
                        }
                        return larger;
                    }
                    
                }
            }
          
            return digits;    
        }


    public static void main(String[] args) {
        test66 example = new test66();

/************ below for Nr.66 input ****************************/      

        int N = StdIn.readInt();
        StdOut.println(" N is " + N);
        int[] a = new int[N];
        
        for (int i = 0; i < N; i++) {
            a[i] = StdIn.readInt();
            StdOut.println("a["+i+"] is "+a[i]);
        }
        


/**************below for Nr.66 algorithms **********************/

        int[] b = new int[N];
        b = example.plusOne(a);
        
        for (int i = 0; i < b.length; i++) {
            StdOut.println("b["+i+"] is "+b[i]);
        }

        // 8999 + 1 => 9000
    }

}
	