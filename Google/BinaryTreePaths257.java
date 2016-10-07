package Google;

import java.util.ArrayList;
import java.util.List;
import tree.TreeNode;

/**
 * Created by xicheng on 16/10/3.
 *
 * Given a binary tree, return all root-to-leaf paths.

 Have you met this question in a real interview? Yes
 Example
 Given the following binary tree:

 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 [
 "1->2->5",
 "1->3"
 ]

 */

/**
 * Definition of TreeNode:
 */



public class BinaryTreePaths257 {


    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */

    // static output array shall NOT be init here, otherwise previous testcase results can not be overwriten !!
    static ArrayList<String> result ;

    private static void passDownPaths(String thisPath, TreeNode root) {
        if ( root != null && root.left == null && root.right == null ) {
            thisPath += "->" ;

            thisPath += root.val ;
            result.add(thisPath);  // only add the path that leads to leaf node into result
            return;
        }

        thisPath += "->" ;

        thisPath += root.val ;

        if (root.left != null) {
            passDownPaths(thisPath, root.left);
        }
        if (root.right != null) {
            passDownPaths(thisPath, root.right);
        }

    }

    public static List<String> BinaryTreePaths(TreeNode root) {

        // static output array shall be init here, otherwise previous testcase results can not be overwriten !!

        result = new ArrayList<String>();

        if ( root == null ) {
            return result;
        }

        String thislevel = "";


        thislevel += root.val;


        if (root.left != null) {
            passDownPaths(thislevel, root.left);
        }
        if (root.right != null) {
            passDownPaths(thislevel, root.right);
        }

        if (root.right == null && root.left == null ) {
            result.add( thislevel );
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(" *******  print out each root to leaf path ****** ");

        TreeNode myroot = new TreeNode( 1 );

        System.out.println(" root is  " + myroot.val );

        TreeNode myrootleft = new TreeNode( 2 );
        TreeNode myrootright = new TreeNode( 3 );
        myroot.left = myrootleft;
        myroot.right = myrootright;
        TreeNode myleftright = new TreeNode( 5 );
        myrootleft.right = myleftright;


        BinaryTreePaths( myroot );

        System.out.println(" size of result is  " + result.size() );

        for ( String path: result
             ) {
            System.out.println(" one path is  " + path );
        }
    }
}
