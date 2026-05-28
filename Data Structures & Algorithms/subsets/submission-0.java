class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(nums,0,ans,new ArrayList<>());
        return ans;
    }
    public void generate(int[] nums, int i,List<List<Integer>> ans, List<Integer> subset){
        if (i == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }

        generate(nums,i+1,ans,subset);

        subset.add(nums[i]);
        generate(nums,i+1,ans,subset);
        subset.remove(subset.size()-1);
    }

}
