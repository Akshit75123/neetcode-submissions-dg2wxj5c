class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l=0,r=0;
        int[] hash = new int[26];
        int maxFreq=0,maxL=0;
        while(r<n)
        {
            hash[s.charAt(r)-'A']++;
            for (int i:hash)
                maxFreq = Math.max(maxFreq,i);
            while(((r-l+1)-maxFreq)>k)
            {
                hash[s.charAt(l)-'A']--;
                for (int i:hash)
                    maxFreq = Math.max(maxFreq,i);
                l++;
            }
            maxL = Math.max(r-l+1,maxL);
            r++;
        }
        return maxL;
    }
}
