package tree;

/*
 * Given a binary tree and a sum, 
 * determine if the tree has a root-to-leaf 
 * path such that adding up all the values 
 * along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.


 * */
public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null ) { // root.val > sum make no sense , because val can < 0
        	return false;
        }
        else if (root.val == sum && root.left == null && root.right == null) {
        	return true;
        }
        else { // even if root.val == sum,  but if root is not leaf nodes, pass down temp=0 an return false
        	int temp = sum - root.val;
        	return ( hasPathSum(root.left, temp) || hasPathSum(root.right, temp));
        }
    }
}
