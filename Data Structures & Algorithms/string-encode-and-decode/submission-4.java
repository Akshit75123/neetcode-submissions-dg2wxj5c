class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        if (strs.size()==0)
            return "";
        for (String s:strs)
        {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        if (str.length()==0)
            return strs;
        int n = str.length();
        int i=0,j=0;
        while(i<n)
        {
            j=i;
            while (str.charAt(j)!='#')
            {
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            strs.add(str.substring(j+1,j+1+len));
            i=j+1+len;
        }
        return strs;
    }
}
