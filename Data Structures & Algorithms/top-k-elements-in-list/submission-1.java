class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;
        for (int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for (Map.Entry<Integer,Integer> hs:mp.entrySet()){
            pq.add(new int[]{hs.getValue(),hs.getKey()});
            while (pq.size()>k)
                pq.poll();
        }
        
        int[] ans = new int[k];
        int j=0;
        while(!pq.isEmpty())
        {
            ans[j]=pq.poll()[1];
            j++;
        }
        return ans;
    }
}
