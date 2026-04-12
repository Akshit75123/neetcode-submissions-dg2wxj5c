class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i = 0, j=n-1;
        int max=0;
        while(i<j){
            int h = Math.min(heights[i],heights[j]);
            int b = j-i;
            int ar = h*b;
            max=Math.max(max,ar);
            if (heights[i]<=heights[j])
                i++;
            else 
                j--;
        }
        return max;
    }
}
