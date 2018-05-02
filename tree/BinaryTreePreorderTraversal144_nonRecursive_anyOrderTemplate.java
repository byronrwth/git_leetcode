/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    

    private class Guide{
        // ope == 1: to visit and to record
        // ope == 0: only to visit, but not record
        int ope ;
        TreeNode node ;
        public Guide( int ope, TreeNode node) {
            this.ope = ope ;
            this.node = node;
        }

    }
    
    // @Fengqinyuan
    public List<Integer> preorderTraversal(TreeNode root) {

        
        List<Integer> result = new ArrayList<>() ;
        
        // dequeeu VS. stack ??
        //Deque < Guide> path = new ArrayList<>() ;
        Deque<Guide> path = new ArrayDeque<>() ;
        
        path.addFirst(new Guide(0, root)) ;
        
        
        while( !path.isEmpty() ) {
            
            Guide myguide = path.removeFirst() ;
            
            
            // defensive
            if (myguide.node == null) {   // myguide == null ??
                continue ;
            }
            
            if (myguide.ope == 1) {
                result.add(myguide.node.val);
                
            }
            else {   
                
                // notice: here can be reuse as template for other orders !!
                // preorder: root, left, right  --> in reverse for dequeue
                
                
                path.addFirst(new Guide(0, myguide.node.right)) ;
                
                path.addFirst(new Guide(0, myguide.node.left)) ;
                
                path.addFirst(new Guide(1, myguide.node)) ;
                
                
                
            }
        }
        
        return result ;
    }
  


}