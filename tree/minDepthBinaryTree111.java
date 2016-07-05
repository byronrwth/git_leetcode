package tree;


public class minDepthBinaryTree111 {
	/*
	 * The minimum depth is the number of 
	 * nodes along the shortest path from the root 
	 * node down to the nearest leaf node.
	 * */

	
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        if ( root.left==null && root.right==null) {
        	return 1;
        }
        
        int left = Integer.MAX_VALUE ;
        int right = Integer.MAX_VALUE ;
        
        if (root.left!=null) {
        	left = minDepth(root.left);
        }
        if (root.right !=null) {
        	right = minDepth(root.right);
        }


        return Math.min(left, right) + 1 ;
    }
}
