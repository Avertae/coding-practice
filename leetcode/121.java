class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0], profit = 0;
        for (int i = 1; i < n; i++) {
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}
