class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] hash = new int[26];
        int m = tasks.length;
        for (int i=0;i<m;i++){
            
                hash[tasks[i]-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<26;i++){
            if (hash[i]>0)
                pq.offer(hash[i]);
        }
        int cnt=0;
        while(!pq.isEmpty()){
            int k = n+1;
            List<Integer> list = new ArrayList<>();
            while(k-->0 && !pq.isEmpty()){
                int t=pq.poll();
                t--;
                list.add(t);
            }
            for (int i:list){
                if (i > 0)
                    pq.offer(i);
            }
            if (pq.isEmpty())
                cnt+=list.size();
            else 
                cnt+=n+1;
        }
        return cnt;
    }
}