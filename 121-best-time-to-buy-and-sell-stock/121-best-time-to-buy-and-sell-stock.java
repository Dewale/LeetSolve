class Solution {
    public int maxProfit(int[] prices) {
        int start = 0;
        int end = 1;
        int max = 0;
        
        if (prices.length == 0) return 1;
        while (end < prices.length) {
            if (prices[start] < prices[end]) {
                max = Math.max(max, prices[end] - prices[start]);
            } else {
                start = end;
            }
            
            end++;
        }
        
        return max;
    }
}

/*
Take 1
Looking into building a sliding window to look through prices
Need to avoid n^2 complexity

*/