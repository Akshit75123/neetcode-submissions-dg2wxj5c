class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = Arrays.stream(piles).max().getAsInt(), ans=0;
        while(start<=end){
            int speed = start+(end-start)/2;
            if (hoursTaken(speed,piles)<=h){  
                ans=speed;
                end=speed-1;
            }
            else 
                start=speed+1;

        }
        return ans;
    }
    private int hoursTaken(int speed, int[] piles) {
        int hours = 0;
        for (int bananas : piles) {
            int val = (int)Math.ceil((double) bananas / speed);
            hours += val;
        }
        return hours;
    }
}
