class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        Arrays.fill(suf,1);
        Arrays.fill(pre,1);
        suf[n-1]=nums[n-1];
        for (int i=n-2;i>=0;i--)
            suf[i]=suf[i+1]*nums[i];
        int[] ans = new int[n];
        ans[0] = suf[1];
        pre[0]=nums[0];
        for (int i=1;i<n-1;i++)
        {
            pre[i] = pre[i-1] * nums[i];
            ans[i]=pre[i-1]*suf[i+1];
        }

        ans[n-1]=pre[n-2];
        return ans;
    }
}  
