class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        for (int i:nums)
            st.add(i);
        int max=0;
        for (int i:st){
            
            if (!st.contains(i-1))
            {
                int cnt=0;
                int num=i;
                while(st.contains(num))
                {
                    num ++;
                    cnt++;
                }
                max=Math.max(max,cnt);
            }
        }
        return max;
    }
}
