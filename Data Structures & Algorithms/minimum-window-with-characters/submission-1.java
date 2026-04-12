class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m>n)
            return "";
        Map<Character,Integer> mp1= new HashMap<>();
        Map<Character,Integer> mp2= new HashMap<>();
        for (char c:t.toCharArray())
            mp1.put(c,mp1.getOrDefault(c,0)+1);

        int len = Integer.MAX_VALUE,x=-1,y=-1;
        int need = mp1.size();
        int r=0,l=0;
        for (r=0;r<n;r++){
            char c=s.charAt(r);
            mp2.put(c,mp2.getOrDefault(c,0)+1);
            if (mp1.containsKey(c)){
                if (mp2.get(c)==mp1.get(c))
                    need--;
            }
            while(need==0){
                if (len>(r-l+1)){
                    len = r-l+1;
                    x=l;
                    y=r;
                }
                mp2.put(s.charAt(l),mp2.get(s.charAt(l))-1);
                
                if (mp1.containsKey(s.charAt(l))){
                    if (mp2.get(s.charAt(l))<mp1.get(s.charAt(l)))
                        need++;
                }
                l++;
            }
        }
        if (x==-1 && y==-1)
            return "";
        return s.substring(x,y+1);
    }
}
