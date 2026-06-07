class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        func(nums,0,list,new ArrayList<>(),target);
        return list;
    }
    public void func(int[] nums, int i, List<List<Integer>> ans, List<Integer> list, int target) {
        if (target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int j=i;j<nums.length;j++){
            if (nums[j] > target)
                break;

            if (j>i && nums[j-1]==nums[j])
                continue;

            
            list.add(nums[j]);

            func(nums,j+1,ans,list,target-nums[j]);

            list.remove(list.size()-1);
        }
    }
}
