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
        	// ����Ҷ�ڵ㣬ҲҪ��previous_node ����Ϊ��Ҷ�ڵ��ٷ��� true�� �Է��� Ҷ�ڵ�Ⱥ���ڵ�ֵ��
               return true;
           }

           // inorder: ����������
           if (!isValidBST(root.left)) {
               return false;
           }
           
           // inorder �������У��нڵ� һ������ ǰһ���ڵ�ֵ��ǰһ���ڵ������� ��ǰ�ǿ�������������һ����ڵ�
           if (previous_node != null && previous_node.val >= root.val) {
        	   // now previous_node is ������ ��ǰ�ǿ�������������һ����ڵ�
               return false;
           }
           
           // ǰһ��node��Ϊ��ǰ root
           previous_node = root ;
           
           if (!isValidBST(root.right)) {
               return false;
           }
           
           return true;
    }
}
