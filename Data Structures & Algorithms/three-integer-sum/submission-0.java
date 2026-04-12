class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int n = nums.length;
        Set<List<Integer>> st = new HashSet<>();
        for (int i=0;i<n;i++){
            int first = nums[i];
            Map<Integer,Integer> mp = new HashMap<>();
            for (int j=i+1;j<n;j++)
            {
                int second = nums[j];
                int third= -(nums[i]+nums[j]);
                if (mp.containsKey(third)){
                    List<Integer> list = Arrays.asList(first,second,third);
                    Collections.sort(list);
                    st.add(list);
                }
                
                mp.put(nums[j],1);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
}
