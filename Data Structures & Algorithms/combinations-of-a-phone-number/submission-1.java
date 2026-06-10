class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> list = new ArrayList<>();
        if (digits.length()==0)
            return list;
        Map<Character,String> mp = new HashMap<>();
        mp.put('2',"abc");
        mp.put('3',"def");
        mp.put('4',"ghi");
        mp.put('5',"jkl");
        mp.put('6',"mno");
        mp.put('7',"pqrs");
        mp.put('8',"tuv");
        mp.put('9',"wxyz");

        func(0,digits,new StringBuilder(),list,mp);
        return list;
    }
    private void func(int index,String digits,StringBuilder sb, List<String> res,Map<Character,String> mp){
        if (index == digits.length()){
            res.add(sb.toString());
            return;
        }

        String str = mp.get(digits.charAt(index));
        for (char c:str.toCharArray()){
            sb.append(c); 
            func(index+1,digits,sb,res,mp);
            sb.setLength(sb.length()-1); //backtracking
        }
    }
}
