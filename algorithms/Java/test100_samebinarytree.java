import java.io.BufferedInputStream;
/*import StdIn;
import StdOut;*/
import java.lang.*;
import java.util.*;

/*import StdIn;
import StdOut;*/



public class test100_same_binary_tree {
    
    public test100_same_binary_tree() {
    }
    
    
/* 
    100_same_binary_tree. solution for Same binary Tree.
    Given two binary trees, write a function to check if they are equal or not.

	Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
*/   
    public boolean isSameTree(TreeNode p, TreeNode q) {
                        boolean result = true;
                        
                        if( p == null && q == null){
                            
                        }
                        else if ( p!=null && q!=null && p.val == q.val) {
                            result = isSameTree(p.left, q.left);
                            if (result) {
                                result = isSameTree(p.right, q.right);
                            }
                        }
                        else {
                            result = false;
                            return result;
                        }
                        
                        return result;  
    }

    public static void main(String[] args) {
        test100_same_binary_tree example = new test100_same_binary_tree();

/************ below for Nr.100_same_binary_tree input ****************************/      



/**************below for Nr.100_same_binary_tree algorithms **********************/



    }

}
	