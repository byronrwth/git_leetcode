package tree;

/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 * */

public class SymmetricTree101 {
	private boolean isSymmetricTree(TreeNode root1, TreeNode root2) {
		if (root1 ==null && root2 ==null) {
			return true;
		}
		else if ( root1 != null && root2!=null && root1.val == root2.val) {
			return ( isSymmetricTree(root1.left, root2.right) &&
					isSymmetricTree(root1.right, root2.left)) ;
		}
		else 
			return false;
	}
	
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return isSymmetricTree(root.left, root.right );
        
    }
}
