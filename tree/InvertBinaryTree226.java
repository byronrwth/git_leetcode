package tree;

/*
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 * */
public class InvertBinaryTree226 {
	 public class TreeNode {
	       int val;
	       TreeNode left;
		     TreeNode right;
		      TreeNode(int x) { val = x; }
	 }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);
        
        root.right = right;
        root.left = left;
        
        return root;
    }
}
