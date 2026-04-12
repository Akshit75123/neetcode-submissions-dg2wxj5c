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
class Pair{
    int f,s;
    Pair(int f,int s){
        this.f=f;
        this.s=s;
    }
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        List<Pair> p = new ArrayList<>();
        func(root,p);
        for (int i=0;i<p.size();i++){
            if (Math.abs(p.get(i).f-p.get(i).s)>1)
                return false;
        }
        return true;
    }
    public int func(TreeNode root,List<Pair> p){
        if (root == null)
            return 0;
        int left = func(root.left,p);
        int right = func(root.right,p);
        p.add(new Pair(left,right));
        return Math.max(left,right)+1;
    }
}
