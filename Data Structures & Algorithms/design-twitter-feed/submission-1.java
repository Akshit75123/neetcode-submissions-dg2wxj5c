class Twitter {
    Map<Integer,HashSet<Integer>> followers;
    Map<Integer, List<int[]>> tweets;
    int count;
    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
        count=0;
    }
    
    public void postTweet(int userId, int tweetId) {

        if (tweets.get(userId)==null){
            List<int[]> list = new ArrayList<>();
            list.add(new int[]{count++,tweetId});
            tweets.put(userId,list);
        }
        else {
            List<int[]> list = tweets.get(userId);
            list.add(new int[]{count++,tweetId});
            tweets.put(userId,list);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        List<int[]> userList = tweets.get(userId);
        if (userList!=null){
            for (int i=0;i<userList.size();i++){
            
                pq.offer(userList.get(i));
                if (pq.size()>10)
                    pq.poll();
            }
        }
        
        if (followers.containsKey(userId)){
            for (int it:followers.get(userId)){
                if (it == userId)
                    continue;
                if (tweets.containsKey(it)){
                    List<int[]> list = tweets.get(it);
                    for (int i=0;i<list.size();i++){
                        pq.offer(list.get(i));
                        if (pq.size()>10)
                            pq.poll();
                    }
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll()[1]);
        }
        Collections.reverse(ans);
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followers.get(followerId)!=null){
            HashSet<Integer> st = followers.get(followerId);
            st.add(followeeId);
            followers.put(followerId,st);
        }
        else {
            HashSet<Integer> st = new HashSet<>();
            st.add(followeeId);
            followers.put(followerId,st);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followers.get(followerId)!=null){
            HashSet<Integer> st = followers.get(followerId);
            st.remove(followeeId);
            followers.put(followerId,st);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */