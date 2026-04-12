class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int start = 0, end = n-1,ans=Integer.MAX_VALUE;
        while(start<=end){
            if (arr[start]<=arr[end]){
                ans=Math.min(ans,arr[start]);
                break;
            }
            int mid = start+(end-start)/2;
            if (arr[mid]>=arr[start]){
                ans = Math.min(ans,arr[start]);
                start=mid+1;
            }
            else{
                ans=Math.min(arr[mid],ans);
                end=mid-1;
            } 
            
        }
        return ans;
    }
}
