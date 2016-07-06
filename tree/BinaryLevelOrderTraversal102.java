package tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree, return the level order traversal 
 * of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * 
 * 
 * */

public class BinaryLevelOrderTraversal102 {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    
    /**
     * Definition of TreeNode:
     */
    public class TreeNode {
          public int val;
          public TreeNode left, right;
          
          public TreeNode(int val) {
              this.val = val;
              this.left = this.right = null;
          }
          
      }
    
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // this Array is for while
        ArrayList result = new ArrayList();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        /*
         * The offer method inserts an element if possible, otherwise returning
         * false. This differs from the Collection.add method, which can fail to
         * add an element only by throwing an unchecked exception. The offer
         * method is designed for use when failure is a normal, rather than
         * exceptional occurrence, for example, in fixed-capacity (or "bounded")
         * queues
         * 
         */
        queue.offer(root);

        while (!queue.isEmpty()) {

            // queue ÿ�γ����е� node ���Լ� �����ӽڵ�ӵ� queue ��β
            // ������ ��node ���� arraylist ��Ϊ �����������
            
            // ÿ�α��� queue �����нڵ㣬��Щ�ڵ�ȫ�����ϲ��� �ӽڵ�
            // this is each level Array
            ArrayList thislevel = new ArrayList();
            int size = queue.size();
            
            for (int i = 0; i < size; i++ ) {
                TreeNode outNode = queue.poll();
                
                // ���ص��� ֵ�� ��Ҫ��ַ��
                thislevel.add(outNode.val);
                
                if (outNode.left != null) {
                    queue.offer(outNode.left);
                }
                if (outNode.right != null) {
                    queue.offer(outNode.right);
                }
            }

            // addAll ���״�ɢ �ӽṹ
            //result.addAll(thislevel); // {1,2,3} --> [1,2,3]
            result.add(thislevel); // {1,2,3} --> [[1],[2,3]]

        }

        return result;
    }
}
