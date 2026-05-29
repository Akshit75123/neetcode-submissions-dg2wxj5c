class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(nums, nums.length - 1, ans, new ArrayList<>(), target);
        return ans;
    }

    public void generate(int[] nums, int i, List<List<Integer>> ans, List<Integer> list, int sum) {
        // Base Case 1: If target sum is met, take a snapshot and return
        if (sum == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        // Base Case 2: If sum goes negative or we run out of elements, stop
        if (sum < 0 || i < 0) {
            return;
        }

        // Choice 1: "Not-Pick" -> Skip the current number and move to the next index
        generate(nums, i - 1, ans, list, sum);

        // Choice 2: "Pick" -> Include current number (staying at index 'i' to allow reuse)
        list.add(nums[i]);
        generate(nums, i, ans, list, sum - nums[i]); 
        
        // Backtrack: Clean up the shared list state before returning up the stack
        list.remove(list.size() - 1);
    }
}