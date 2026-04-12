class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length,m = mat[0].length;
        int start = 0, end = n*m-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            int row = mid / m;
            int col = mid % m;
            int ele = mat[row][col];
            // System.out.println(ele);
            if (ele == target)
                return true;
            else if (ele>target)
                end = mid-1;
            else 
                start = mid+1;
        }
        return false;
    }
}
