
import java.io.BufferedInputStream;
/*import StdIn;
import StdOut;*/
import java.lang.*;
import java.util.*;

/*import StdIn;
import StdOut;*/



public class test {
    
    public test() {

    }
    
    
    
//    26 Remove Duplicates from Sorted Array
/*    Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

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
    
/*   27. Remove Element Total Accepted: 30153 Total Submissions: 91543 My Submissions Question Solution 
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
    
/*   58. Length of Last Word Total Accepted: 23603 Total Submissions: 81480 My Submissions Question Solution 
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of non-space characters only.

    For example, 
    Given s = "Hello World",
    return 5.*/
    //public class Solution {
        public int lengthOfLastWord(String s) {
            
            if (s.length() == 0) return 0;
            int i = s.length()-1;
            int j = 0;
            for (; i >= 0; --i) { 
                StdOut.printf(" char at s[i] is : ");
                StdOut.print(s.charAt(i));
                StdOut.printf("i: " +i);
                if (!(s.charAt(i)==' ')) {
                    j++;
                }
                else //s.charAt(i)==' '
                    if (j!= 0) {
                        break; 
                    }
//                if (i == 0) break;
                StdOut.printf("i: " +i);
            }
           
            return j;
            
        }
    //}
//    
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
        
//        }

//            Remove Duplicates from Sorted List
             /**
             * Definition for singly-linked list.
             */
            
              public class ListNode {
                  int val;
                  ListNode next;
//                  ListNode() {
//                      
//                  }
                  ListNode(int x) {
                      val = x;
                      next = null;
                  }
              }
             

              public ListNode deleteDuplicates(ListNode head) {
                  ListNode p = head;
                  while(p != null) {
                      if (p.next != null ) {
                          while (p.next.val == p.val) {
                              StdOut.println("p: " + p.val + " to remove: p.next is: " + p.next.val);
                              p.next = p.next.next;
                              if (p.next == null) return head;
                          }
                      
                          StdOut.println("p: " + p.val+" after remove: p.next is: " + p.next.val);
                      }
                      p = p.next;
                  }
                  
                  return head;
              }
              
              
              
              
//                Same Tree
                /**
                 * Definition for binary tree
                 * public class TreeNode {
                 *     int val;
                 *     TreeNode left;
                 *     TreeNode right;
                 *     TreeNode(int x) { val = x; }
                 * }
                 */
//                public class Solution {
                public class TreeNode {
                         int val;
                         TreeNode left;
                         TreeNode right;
                         TreeNode(int x) { val = x; }
                     }
                
                    public boolean isSameTree(TreeNode p, TreeNode q) {
                        boolean result = true;
                        
                        if( p == null && q == null){
                            
                        }
                        else if ( p!=null && q!=null && p.val == q.val) {
                            if (isSameTree(p.left, q.left)) {
                                result = isSameTree(p.right, q.right);
                            }
                        }
                        else {
                            result = false;
                            return result;
                        }
                        
                        return result;
                    }
                    
                    
                    
                    public boolean isSymmetric(TreeNode root) {
                        
                        return false;
                    }

//                }

    public static void main(String[] args) {
        test example = new test();
//        ListNode p = new ListNode(2);
//        test Solution = new test();
        
/*        StdOut.printf(string)
        StdOut.println(int / char / boolean/ object)
        StdOut.print(int / char / boolean/ object)*/
        
        
/*     array test  
 *      int N = StdIn.readInt();
        StdOut.println(" N is " + N);
        int[] a = new int[N];
        
        *//**
         * Print an array of ints to standard input.
         *//*
        for (int i = 0; i < N; i++) {
            a[i] = StdIn.readInt();
            StdOut.println("a["+i+"] is "+a[i]);
        }
        
        
//        int new_len = example.solu1_removeDuplicates(a);
//        int new_len = example.solu2_removeDuplicates(a, N);
//        int new_len = example.solu3_removeDuplicates(a);
        
        int elem = StdIn.readInt();
        StdOut.println(" elem is " + elem);
        int new_len = example.removeElement(a, elem);
        
        
        *//**
         * Print an array of ints to standard output.
         *//*

        for (int i = 0; i < new_len; i++) {
                StdOut.printf("%9d ", a[i]);
        }*/

        /**
        * Print an string of ints to standard input / output.
        */
        
/*        String ins = StdIn.readLine();
        
        StdOut.printf(" input str is : ");
        
        StdOut.printf(ins);
        int a = example.lengthOfLastWord(ins);
        StdOut.printf(" last word length of str is : ");
        StdOut.println(a);*/

        // Plus One
//        int a = StdIn.readInt();
//        while (a){
//            
//        }
        
/*        int N = StdIn.readInt();
        StdOut.println(" N is " + N);
        int[] a = new int[N];
        
        for (int i = 0; i < N; i++) {
            a[i] = StdIn.readInt();
            StdOut.println("a["+i+"] is "+a[i]);
        }
        
        int[] b = new int[N];
        b = example.plusOne(a);
        
        for (int i = 0; i < b.length; i++) {
            StdOut.println("b["+i+"] is "+b[i]);
        }*/
        
/*        
 *      ListNode myqueue = null;        
        ListNode q = null;
        int N = StdIn.readInt();
        StdOut.println(" N is " + N);
        for (int i=0; i < N; i++) {
            int x = StdIn.readInt();
            myqueue = example.new ListNode(x);
            if (q == null) {
                q = myqueue;
            }
            else {
                myqueue.next = q;
                q = myqueue;
            }
            
            StdOut.println("q(val) is "+q.val);
            if (q.next != null) {
                StdOut.println("q(val).next is "+q.next.val);
            }
        }
        if (q != null) {
            ListNode resultq = null;
            resultq = example.deleteDuplicates(q);
//            resultq = q;
            while(resultq !=null) {
                StdOut.println("resultq(val) is " + resultq.val);
                if (resultq.next != null ) {
                    StdOut.println("resultq(val).next is " + resultq.next.val);
                   
                }
                resultq = resultq.next;
            }
        }*/
  
        
        // ? how to input / output binary tree ?
        
        
        
    }

}
