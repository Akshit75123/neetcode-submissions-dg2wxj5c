class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = stones.length;
        for (int i=0;i<n;i++)
            pq.add(stones[i]);
        while(pq.size()>1){
            int val1 = pq.poll();
            int val2 = pq.poll();
            if (val1!=val2){
                pq.add(Math.abs(val1-val2));
            }
        }
        if (pq.size()==0)
            return 0;
        return pq.peek();
    }
}