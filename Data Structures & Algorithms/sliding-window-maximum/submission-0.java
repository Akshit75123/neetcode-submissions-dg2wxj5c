class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int j=0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i=0;i<n;i++){
            // shrinking the size of the window if size increases from k
            while(!dq.isEmpty() && (i - dq.peekFirst()) == k)
                dq.pollFirst();
            // maintaining the monotonic decreasing queue
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();
            dq.offerLast(i);
            if (i>=k-1)
                ans[j++]=nums[dq.peekFirst()];
        }
        return ans;
    }
}
