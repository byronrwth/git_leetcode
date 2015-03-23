import java.io.BufferedInputStream;
/*import StdIn;
import StdOut;*/
import java.lang.*;
import java.util.*;

/*import StdIn;
import StdOut;*/



public class test26 {
    
    public test26() {
    }
    
    
/* 
    26. solution for removeDuplicates from Sorted Array
    Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

            Do not allocate extra space for another array, you must do this in place with constant memory.

            For example,
            Given input array A = [1,1,2],

            Your function should return length = 2, and A is now [1,2].*/
      public int solu1_removeDuplicates(int[] A) {
        if (A.length == 0)
            return 0;
        int i = 0; //right most valid element
        for (int j = 1; j < A.length; j++) {
            if (A[j] != A[i]) { //when not equals to right most valid, means this is also valid, extend the valid array
                i++;
                A[i] = A[j];
            }
        }

        return i + 1; 
    }
    
    public int solu2_removeDuplicates(int[] A, int n) {
        int j = 0;
        for (int i = 0; i < n; ++i){
            
            if (i == 0 || A[i] != A[i-1]){
                StdOut.printf("before: i is "+i+" j is "+j);
                A[j++] = A[i];
                StdOut.printf("after: i is "+i+" j is "+j);
            }
        }
        return j;
    }
    
    public int solu3_removeDuplicates(int[] A) {
        int i , j = 0;
        if (A.length == 0) return 0;
        
        for( i =0, j=0; i <A.length; i++){
            if(A[i] != A[j]){
                // if A.length == 1: ++j wont trigger
                A[++j]=A[i];
            }
        }
        return (j+1);
    }


    public static void main(String[] args) {
        test26 example = new test26();

/************ below for Nr.26 input ****************************/      
		//     array test  
      int N = StdIn.readInt();
        StdOut.println(" N is " + N);
        int[] a = new int[N];
        

		// Print an array of ints to standard input.
        for (int i = 0; i < N; i++) {
            a[i] = StdIn.readInt();
            StdOut.println("a["+i+"] is "+a[i]);
        }


/**************below for Nr.26 algorithms **********************/
        int new_len = example.solu1_removeDuplicates(a);
//        int new_len = example.solu2_removeDuplicates(a, N);
//        int new_len = example.solu3_removeDuplicates(a);


        for (int i = 0; i < new_len; i++) {
                StdOut.printf("%9d ", a[i]);
        }

        StdOut.println("new length is "+ new_len);
    }

}
			