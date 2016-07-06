package tree;

/*
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: ¡°The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).¡±

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

http://www.lintcode.com/en/problem/lowest-common-ancestor/
Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7

 * */
public class LowestCommonAncestorOfBinarySearchTree235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // find end node, or find A or B, search on this subtree can finish now
        if ( root == null || p == root || q == root) {
            return root ;
        }
        
        // else keep looking for A or B, or end node
        TreeNode left = null;
        TreeNode right = null;
            
        // divide :             
        // decide whether both nodes are on the left or right subtree of root
        if (root.left != null) {
            left = lowestCommonAncestor(root.left, p, q);
        }
        if (root.right != null) {
            right = lowestCommonAncestor(root.right, p, q);
        }
            
        // conquer: if both left and right subtree find !null means A,B are seperated by root, root is LCA
        if (left != null && right != null) {
            return root;
        }
        else if (left != null) { // else left node is LCA of another node
            return left;
        }
        else if (right != null) { // else right node is LCA of another node
            return right;
        }
        else 
            return null; // else both nodes are not in this subtree. LCA is null
    }
}
