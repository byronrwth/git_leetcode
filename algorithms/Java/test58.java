import java.io.BufferedInputStream;
/*import StdIn;
import StdOut;*/
import java.lang.*;
import java.util.*;

/*import StdIn;
import StdOut;*/



public class test58 {
    
    public test58() {
    }
    
    
/* 
    58. solution for lengthOfLastWord. Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of non-space characters only.

    For example, 
    Given s = "Hello World",
    return 5.
*/   
      public int lengthOfLastWord(String s) {
            
            if (s.length() == 0) return 0;
            int i = s.length()-1;
            int j = 0;
            for (; i >= 0; --i) { 
                //StdOut.printf(" char at s[i] is : ");
                //StdOut.print(s.charAt(i));
                // StdOut.printf("i: " +i);
                if (!(s.charAt(i)==' ')) {
                    j++;
                }
                else //s.charAt(i)==' '
                    if (j!= 0) {
                        break; 
                    }
//                if (i == 0) break;
                //StdOut.printf("i: " +i);
            }
           
            return j;
            
        }

    public static void main(String[] args) {
        test58 example = new test58();

/************ below for Nr.58 input ****************************/      



        //Print an string of ints to standard input / output.

        
        String ins = StdIn.readLine();
        
        StdOut.printf(" input str is : " + ins);
       


/**************below for Nr.58 algorithms **********************/


        int a = example.lengthOfLastWord(ins);
        StdOut.printf(" last word length of str is : ");
        StdOut.println(a);

    }

}
	