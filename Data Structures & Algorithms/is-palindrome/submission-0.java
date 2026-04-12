class Solution {
    public boolean isAlphaNumeric(char ch)
    {
        if ((ch>=48 && ch<=57) || (ch>=65 && ch<=90) || (ch>=97 && ch<=122))
            return true;
        return false;
    }
    public boolean isUpperCase(char ch)
    {
        if (ch>='A' && ch<='Z')
            return true;
        return false;
    }
    public char toLowerCase(char ch)
    {
        return (char)(ch+32);
    }
    public boolean isPalindrome(String s) {
        int n = s.length();
        int i=0, j=n-1;
        while(i<j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (!isAlphaNumeric(ch1)){
                i++;
                continue;
            }
            if (!isAlphaNumeric(ch2)){
                j--;
                continue;
            }
            if (isUpperCase(ch1))
                ch1=toLowerCase(ch1);
            if (isUpperCase(ch2))
                ch2=toLowerCase(ch2);
            if (ch1 != ch2)
                return false;
            i++;
            j--;
        }
        return true;
    }
}
