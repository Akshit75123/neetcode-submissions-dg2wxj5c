class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n= s1.length();
        int m=s2.length();
        if (n>m)
            return false;
        int l=0;
        int r=0;
        int[] hash = new int[26];
        for (int i=0;i<n;i++)
            hash[s1.charAt(i)-'a']++;
        while(r<m){
            hash[s2.charAt(r)-'a']--;
            if ((r-l+1)>n){
                //have the window of size 3
                hash[s2.charAt(l)-'a']++;
                
                l++;
                
            }
            if ((r-l+1) == n)
            {
                int cnt=0;
                for (int i=0;i<26;i++){
                    if (hash[i]==0)
                        cnt++;
                    else
                        break;
                }
                if (cnt==26)
                    return true;
                
            }
            r++;
        }
        return false;
    }
}
