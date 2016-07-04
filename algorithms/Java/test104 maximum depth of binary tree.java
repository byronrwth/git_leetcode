import java.io.BufferedInputStream;
/*import StdIn;
import StdOut;*/
import java.lang.*;
import java.util.*;

/*import StdIn;
import StdOut;*/



public class test104 {
    
    public test104() {
    }
    
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */    
/*                                  
    104. solution for maximumdepthofbinarytree.
    Given a binary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/   
    public int maxDepth(TreeNode root) {
        int leftmax, rightmax = 0;

        if root == null return 0;
        if (root.left != null) {
            leftmax = maxDepth(root.left);
        }
        if (root.right != null) {
            rightmax = maxDepth(root.right);
        }
        if (leftmax > rightmax) return leftmax+1;
        else return rightmax+1;
    }

    public static void main(String[] args) {
        test104 example = new test104();

/************ below for Nr.104 input ****************************/      



/**************below for Nr.104 algorithms **********************/

        example.maximumdepthofbinarytree();

    }

}
    