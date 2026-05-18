class Helper{
    int[] point;
    int dis;
    Helper(int[] point,int d){
        this.point = point;
        dis=d;
    }
}
class Solution {
    public int dist(int x,int y){
        return (int)(Math.pow(x,2)+Math.pow(y,2));
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Helper>  pq = new PriorityQueue<>((a,b)->b.dis-a.dis);
        for (int i=0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];
            int dis = dist(x,y);
            pq.offer(new Helper(points[i],dis));
            if (pq.size()>k){
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];
        for (int i=0;i<k;i++){
            int[] val = pq.poll().point;
            ans[i]=val;
        }
        return ans;
    }
}