import java.io.BufferedInputStream;
/*import StdIn;
import StdOut;*/
import java.lang.*;
import java.util.*;

/*import StdIn;
import StdOut;*/



public class test83 {
    
    public test83() {
    }
    
    
/* 
    83. solution for deleteDuplicates.
*/   
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
  public class ListNode {
      int val;
      ListNode next;
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

    public static void main(String[] args) {
        test83 example = new test83();

/************ below for Nr.83 input ****************************/      

      
       ListNode mynode = null;        
        ListNode q = null;
        int N = StdIn.readInt();
        StdOut.println(" N is " + N);
        for (int i=0; i < N; i++) {
            int x = StdIn.readInt();
            mynode = example.new ListNode(x);
            if (q == null) {
                q = mynode;
            }
            else {
                mynode.next = q;
                q = mynode;
            }
            
            StdOut.println("q(val) is "+q.val);
            if (q.next != null) {
                StdOut.println("q(val).next is "+q.next.val);
            }
        }


/**************below for Nr.83 algorithms **********************/
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
        }


    }

}
	