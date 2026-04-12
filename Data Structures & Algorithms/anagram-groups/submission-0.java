class Solution {
    private boolean areAnagrams(String s,String t)
    {
        int[] hash = new int[26];
        int n = s.length(),m=t.length();
        for (char c:s.toCharArray())
        {
            hash[c-'a']++;
        }
        for (char c:t.toCharArray())
        {
            hash[c-'a']--;
        }

        for (int i=0;i<26;i++)
        {
            if (hash[i]!=0)
                return false;
        }
        return true;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int n  = strs.length;
        Map<String,List<String>> mp = new HashMap<>();
        for (int i=0;i<n;i++)
        {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if (mp.containsKey(s))
            {
                List<String> list = mp.get(s);
                list.add(strs[i]);
            }
            else{
                List<String> arr = new ArrayList<>();
                arr.add(strs[i]);
                mp.put(new String(ch),arr);
            }   
        }
        for (Map.Entry<String,List<String>> hs:mp.entrySet())
        {
            ans.add(hs.getValue());
        }
        // System.out.println(mp);
        return ans;
    }
}
