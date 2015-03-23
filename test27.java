
import java.io.BufferedInputStream;
/*import StdIn;
import StdOut;*/
import java.lang.*;
import java.util.*;

/*import StdIn;
import StdOut;*/



public class test27 {
    
    public test27() {

    }
    
/* 
    27. Remove Element 
    Given an array and a value, remove all instances of that value in place and return the new length.

    The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/   
    public int removeElement(int[] A, int elem) {
        int i=0,j = 0;
        
        if (A.length != 0) {
            for(; i < A.length; i++) {
                if ( A[i] !=elem) {
                    if (A[j] == elem){
                        A[j]=A[i];
                        A[i]=elem;
                    }
                    j++;
                }
            }
            
        }
        return j;
    }
    


    public static void main(String[] args) {
        test27 example = new test27();



/************ below for Nr.27 input ****************************/      

//   array test  

       int N = StdIn.readInt();
        StdOut.println(" N is " + N);
        int[] a = new int[N];
        

// Print an array of ints to standard input.

        for (int i = 0; i < N; i++) {
            a[i] = StdIn.readInt();
            StdOut.println("a["+i+"] is "+a[i]);
        }
        



/**************below for Nr.27 algorithms **********************/

        int elem = StdIn.readInt();
        StdOut.println(" elem is " + elem);
        int new_len = example.removeElement(a, elem);
        StdOut.println("new length is "+ new_len);
       




    }

}
