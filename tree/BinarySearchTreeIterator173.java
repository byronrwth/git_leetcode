package tree;

import java.util.Stack;

/*
 * Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time 
and uses O(h) memory, where h is the height of the tree.

Example
For the following binary search tree, 
in-order traversal by using iterator is [1, 6, 10, 11, 12]

   10
 /    \
1      11
 \       \
  6       12
 * */

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class BinarySearchTreeIterator173 {

    private Stack<TreeNode> stack = new Stack<TreeNode>();
    private TreeNode curt;
    
    public void BSTIterator(TreeNode root) {
        TreeNode curt = root;
        stack.push(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return (curt != null || !stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        // root, root.left
        while (curt != null) {
            stack.push(curt);
            curt = curt.left;
        }
        
        // find the last emelent in stack but don't pop out
        //curt = stack.peek();
        
        //no left subtree anymore, add right subtree
        curt = stack.pop();
        
        TreeNode node = curt;
        curt = curt.right;
        
        return node.val;
    }
}
