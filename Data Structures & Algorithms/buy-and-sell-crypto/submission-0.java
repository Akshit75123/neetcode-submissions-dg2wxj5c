class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0,cost=prices[0];
        for (int i=0;i<prices.length;i++){
            profit = Math.max(profit,prices[i]-cost);
            cost = Math.min(prices[i],cost);
        }
        return profit;
    }
}
