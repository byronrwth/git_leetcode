package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.BinaryLevelOrderTraversal102.TreeNode;

/*
 * Given a binary tree, return the bottom-up level 
 * order traversal of its nodes' values. (ie, from left
 *  to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 * */

public class BinaryTreeLevelOrderTraversalII107 {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList result = new ArrayList();
        Stack<ArrayList<Integer>> temp = new Stack<ArrayList<Integer>>() ;
        
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

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
            temp.push(thislevel); // {1,2,3} --> [[1],[2,3]]

        }

        while ( !temp.isEmpty()) {
        	result.add( temp.pop()) ;
        }
        
        return result;
    }
}
