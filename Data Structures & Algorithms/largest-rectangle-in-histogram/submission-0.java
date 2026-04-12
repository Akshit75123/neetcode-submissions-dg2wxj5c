class Solution {
    private void findNextSmallerElement(int[] arr,int[] nse,int n){
        Stack<Integer> st = new Stack<>();
        for (int i=n-1;i>=0;i--){
            int curr = arr[i];
            while(!st.isEmpty() && arr[st.peek()]>=curr)
                st.pop();
            if (st.isEmpty())
                nse[i] = n;
            else 
                nse[i] = st.peek();
            st.push(i);
        }
    }
    private void findPreviousSmallerElement(int[] arr,int[] pse,int n){
        Stack<Integer> st = new Stack<>();
        for (int i=0;i<n;i++){
            int curr = arr[i];
            while(!st.isEmpty() && arr[st.peek()]>=curr)
                st.pop();
            if (st.isEmpty())
                pse[i] = -1;
            else 
                pse[i] = st.peek();
            st.push(i);
        }
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        findNextSmallerElement(heights,nse,n); // -1
        findPreviousSmallerElement(heights,pse,n); // n
        System.out.println(Arrays.toString(nse));
        System.out.println(Arrays.toString(pse));
        int maxArea = 0;
        for (int i=0;i<n;i++){
            int breadth = nse[i]-pse[i]-1;
            int ar = heights[i]*breadth;
            maxArea = Math.max(maxArea,ar);
        }
        return maxArea;
    }
}
