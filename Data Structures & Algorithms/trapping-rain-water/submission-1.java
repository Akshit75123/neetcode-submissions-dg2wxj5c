class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int l =0,r=n-1;
        int lm=0,rm=0;
        int cnt=0;
        while(l<r)
        {
            if (arr[l]<=arr[r])
            {
                if (lm>arr[l]){
                    int water = lm-arr[l];
                    cnt+=water;
                }
                else 
                    lm = arr[l];
                l++;
            }
            else
            {
                if (rm>arr[r])
                {
                    int water = rm-arr[r];
                    cnt+=water;
                }
                else 
                    rm = arr[r];
                r--;
            }
        }
        return cnt;
    }
}
