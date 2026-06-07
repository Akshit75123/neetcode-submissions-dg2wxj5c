class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        func(nums,0,ans,new ArrayList<>());
        return ans;
    }
    public void func(int[] nums, int i,List<List<Integer>> ans, List<Integer> subset){
        ans.add(new ArrayList<>(subset));

        for (int j = i;j < nums.length; j++){
            if (j > i && nums[j] == nums[j-1])
                continue;

            subset.add(nums[j]);

            func(nums,j+1,ans,subset);

            subset.remove(subset.size()-1);
        }
    }
}
