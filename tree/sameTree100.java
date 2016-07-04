package tree;

public class sameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean result = false;
        
        if ( p==null && q==null) {
            return true;
        }
        else if (p!=null && q!=null) {
            if (p.val == q.val) {
                if (isSameTree(p.left, q.left)==true && isSameTree(p.right, q.right)==true) {
                    result = true;
                }
                else return false;
            }
            else return false;
        }
        else return false;
        
        return result;
    }
}
