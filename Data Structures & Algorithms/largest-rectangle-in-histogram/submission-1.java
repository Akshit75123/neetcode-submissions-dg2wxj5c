class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for (int i=0;i<n;i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                int nse = i;
                int ele = st.pop();
                int pse = !st.isEmpty() ? st.peek() : -1;
                // // for bar = 1 height =7
                // before popping 7 from the st because 1 has to be pushed 
                // 1<7
                // nse of 7 is current (i) = 1
                // pse 
                // st.pop();
                int area = (nse - pse - 1) * heights[ele];
                maxArea = Math.max(area,maxArea);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int nse = n;
            int ele = st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            int area = (nse - pse - 1) * heights[ele];
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
}
