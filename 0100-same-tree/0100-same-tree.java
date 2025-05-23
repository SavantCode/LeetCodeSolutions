class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q==null) return true;
        if(p == null || q==null) return false;

        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }
}

// When both p and q are null, the first condition p == null && q == null is true, so the function returns true immediately and does not execute the second condition.