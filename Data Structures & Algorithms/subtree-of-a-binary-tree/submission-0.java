/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root,subRoot);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null)
            return true;
        if ((p==null && q!=null) || (p!=null && q==null))
            return false;
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public boolean dfs(TreeNode root,TreeNode subRoot){
        if (root == null)
            return false;
        if (root.val == subRoot.val){
            if (isSameTree(root,subRoot))
                return true;
        }
        if (dfs(root.left,subRoot))
            return true;
        if (dfs(root.right,subRoot))
            return true;
        return false;
    }
}
