class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];

        backtrack(list,current,vis,nums.length,nums);

        return list;
    } 

    private void backtrack(List<List<Integer>> list,List<Integer> current,boolean[] vis,int n,int[] nums){
        if (current.size() == n){
            list.add(new ArrayList<>(current));
            return;
        }

        for (int i=0;i<n;i++){
            if (vis[i])
                continue;
            
            current.add(nums[i]);
            vis[i] = true;
            
            backtrack(list,current,vis,n,nums);

            vis[i] = false;
            current.remove(current.size()-1);
        }
    }
    
}
