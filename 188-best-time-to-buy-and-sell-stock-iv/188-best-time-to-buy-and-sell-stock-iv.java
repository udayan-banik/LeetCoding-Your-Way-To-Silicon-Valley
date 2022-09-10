class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) return 0;
        if (k >= prices.length) {
            int profit = 0;
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i-1] >= prices[i]) {
                    min = prices[i];
                } else {
                    profit += prices[i]-min;
                    min = prices[i];
                }
            }
            return profit;
        }
        
        int[] res = new int[prices.length];
        int[] prev = new int[prices.length];

        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0];
            for (int d = 1; d < prices.length; d++) {
                res[d] = Math.max(res[d-1], prices[d] + maxDiff);
                maxDiff = Math.max(maxDiff, prev[d] - prices[d]);
            }
            for (int i = 0; i < res.length; i++) {
                prev[i] = res[i];
            }
        }

        return res[res.length - 1];
    }
}