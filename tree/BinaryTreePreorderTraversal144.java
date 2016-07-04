package tree;
import java.util.*;


public class BinaryTreePreorderTraversal144 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
      }
    }
    
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // precorder:  root,  left, right  前序 = 根 左 右
        ArrayList<Integer> preorder = new ArrayList<Integer>();

/*
        // 1: if recursion
        if (root == null) {
            
            return preorder;
        }
        else {
            preorder.add(root.val);
            
            if (root.left != null) {
                preorder.addAll(preorderTraversal(root.left));
            }

            
            if (root.right != null) {
                preorder.addAll(preorderTraversal(root.right));
            }

        }

        return preorder;
*/        
        
        
        // 2: if not recursion, preorder traversal must use stack
        Stack<TreeNode> Nodes = new Stack<TreeNode>();
        
        if (root == null) {
            //preorder.add(Integer.parseInt("0"));
            return preorder;
        } 
        else {
            Nodes.push(root);
            
            while (!Nodes.empty()) {
                root = Nodes.pop();
                preorder.add(root.val);
              //先 右子树进站，确保 左子树 先出栈
                if (root.right != null) {
                    Nodes.push(root.right);
                }
                
                if (root.left != null) {
                    Nodes.push(root.left);
                }
            }
            return preorder;
        }
        
    }
    

    
}
