class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st= new HashSet<>();
        int l = 0, r = 0,max=0;
        while(r<s.length())
        {
            while (st.contains(s.charAt(r)))
            {
                st.remove(s.charAt(l));
                l++;
            }
            st.add(s.charAt(r));
            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}
