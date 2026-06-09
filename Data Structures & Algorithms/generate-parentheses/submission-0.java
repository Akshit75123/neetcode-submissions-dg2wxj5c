class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        func(n,n,n,new StringBuilder(),list);
        return list;
    }
    public void func(int open,int close,int n,StringBuilder sb,List<String> ans){
        if (sb.length()==n*2){
            ans.add(sb.toString());
            return;
        }

        if (open>0){
            sb.append("(");
            func(open-1,close,n,sb,ans);
            sb.setLength(sb.length()-1);
        }
        if (close>open){
            sb.append(")");
            func(open,close-1,n,sb,ans);
            sb.setLength(sb.length()-1);
        }
    }
}
