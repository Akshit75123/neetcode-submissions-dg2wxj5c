class Tuple{
    String val;
    int time;
    Tuple(String val,int time){
        this.val=val;
        this.time=time;
    }
}
class TimeMap {
    String key;
    Map<String,List<Tuple>> mp;
    public TimeMap() {
        mp= new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Tuple> list = new ArrayList<>();
        if (mp.containsKey(key))
            list = mp.get(key);
        Tuple tuple = new Tuple(value,timestamp);
        list.add(tuple);
        mp.put(key,list);
    }
    
    public String get(String key, int timestamp) {
        if (!mp.containsKey(key))
            return "";
        List<Tuple> list = mp.get(key);
        int start = 0, end = list.size()-1;
        String ans = "";
        while(start<=end){
            int mid = start+(end-start)/2;
            int time = list.get(mid).time;
            if (timestamp == time)
                return list.get(mid).val;
            else if (timestamp>time){
                ans=list.get(mid).val;
                start=mid+1;
            }
            else 
                end=mid-1;
        }
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */