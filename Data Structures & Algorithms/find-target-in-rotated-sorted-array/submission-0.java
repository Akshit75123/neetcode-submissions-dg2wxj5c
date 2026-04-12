class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int start = 0, end = n-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid]>=arr[start]){
                if (target>=arr[start] && target<=arr[mid]){
                    end = mid-1;
                }
                else 
                    start=mid+1;
            }
            //right half is sorted
            else {
                if (target>=arr[mid] && target<=arr[end])
                    start=mid+1;
                else 
                    end= mid-1;
            }
        }
        return -1;
    }
}
