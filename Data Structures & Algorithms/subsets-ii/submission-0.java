class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> st = new HashSet<>();
        generate(nums,0,st,new ArrayList<>());
        for (List<Integer> it:st)
            ans.add(it);
        return ans;
    }
    public void generate(int[] nums, int i,Set<List<Integer>> ans, List<Integer> subset){
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
