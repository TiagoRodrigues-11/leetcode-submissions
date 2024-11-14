class Solution {
    public int maxProfit(int[] prices) {
        int low = 0;
        int high = 1;
        int bestProfit = 0;

        while(high < prices.length) {
            if (prices[low] < prices[high]) {
                int profit = prices[high] - prices[low];
                bestProfit = Math.max(bestProfit, profit);
            } else {
                low = high;
            }

            high += 1;

        }

        return bestProfit;
    }
}