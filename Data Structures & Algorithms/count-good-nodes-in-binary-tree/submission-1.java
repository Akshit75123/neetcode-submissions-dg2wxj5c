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
    public int goodNodes(TreeNode root) {
        int[] cnt={0};
        dfs(root,(int)-1e9,cnt);
        return cnt[0];
    }
    public void dfs(TreeNode root,int max,int[] cnt){
        if (root==null)
            return;
        if (max<=root.val){
            max=root.val;
            cnt[0]++;
        }
        dfs(root.left,max,cnt);
        dfs(root.right,max,cnt);
    }
}
