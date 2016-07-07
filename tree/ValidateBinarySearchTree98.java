package tree;

/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.


http://www.lintcode.com/en/problem/validate-binary-search-tree/
  2
 / \
1   4
   / \
  3/#   5

1, 2, 3/#, 4 ,5
The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).
 * */
public class ValidateBinarySearchTree98 {
    
    
    private TreeNode previous_node = null;
    
    public boolean isValidBST(TreeNode root) {
        if (root == null ) {
        	// 遇见叶节点，也要把previous_node 更新为此叶节点再返回 true， 以防此 叶节点比后面节点值大
               return true;
           }

           // inorder: 左子树遍历
           if (!isValidBST(root.left)) {
               return false;
           }
           
           // inorder 升序排列，中节点 一定大于 前一个节点值，前一个节点来自于 当前非空左子树，或上一层根节点
           if (previous_node != null && previous_node.val >= root.val) {
        	   // now previous_node is 来自于 当前非空左子树，或上一层根节点
               return false;
           }
           
           // 前一个node记为当前 root
           previous_node = root ;
           
           if (!isValidBST(root.right)) {
               return false;
           }
           
           return true;
    }
}
