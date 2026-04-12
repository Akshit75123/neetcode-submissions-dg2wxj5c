class Solution {
    public int longestConsecutive(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int i:nums)
            list.add(i);
        Set<Integer> st = new HashSet<>();
        int max=0;
        for (int i=0;i<n;i++){
            int num = nums[i];
            int cnt=0;
            if (!st.contains(num-1))
            {
                while(list.contains(num))
                {
                    st.add(num);
                    num ++;
                    cnt++;
                }
                max=Math.max(max,cnt);
            }
        }
        return max;
    }
}
