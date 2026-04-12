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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer,Integer> mp = new HashMap<>();
        for (int i=0;i<n;i++){
            mp.put(inorder[i],i);
        }
        return func(preorder,0,n-1,inorder,0,n-1,mp);

    }
    public TreeNode func(int[] preorder,int ps,int pe,int[] inorder,int is,int ie,Map<Integer,Integer> mp){
        if (ps>pe || is> ie)
            return null;
        int n = inorder.length;
        TreeNode root = new TreeNode(preorder[ps]);
        int indexOfRoot = mp.get(preorder[ps]);
        int numsLeft = indexOfRoot - is;
        root.left = func(preorder,ps+1,numsLeft+ps,inorder,is,indexOfRoot,mp);
        root.right = func(preorder,numsLeft+1+ps,pe,inorder,indexOfRoot+1,pe,mp);
        return root;
    }
}
