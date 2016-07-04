package tree;

public class maxDepthBinaryTree104 {

	 public class TreeNode {
	     int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
    public int maxDepth(TreeNode root) {
        
        // write your code here
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1 ;

    }
}
