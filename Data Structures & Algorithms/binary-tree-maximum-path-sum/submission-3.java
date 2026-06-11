class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = {(int)-1e9};
        dfs(root,max);
        return max[0];
    }   
    public int dfs(TreeNode node, int[] max){
        if (node == null)
            return 0;

        int leftSum = Math.max(0,dfs(node.left,max));
        int rightSum = Math.max(0,dfs(node.right,max));

        max[0] = Math.max(max[0],node.val+leftSum+rightSum);
        return Math.max(leftSum,rightSum) + node.val;
    }
}
