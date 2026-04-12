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
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = {0};
        int[] cnt = {0};
        inorder(root,ans,cnt,k);
        return ans[0];
    }
    public void inorder(TreeNode root,int[] ans,int[] cnt,int k){
        if (root==null)
            return;
        
        inorder(root.left,ans,cnt,k);
        cnt[0]++;
        if (cnt[0] == k){
            ans[0] = root.val;
        }
        inorder(root.right,ans,cnt,k);
    } 
}
