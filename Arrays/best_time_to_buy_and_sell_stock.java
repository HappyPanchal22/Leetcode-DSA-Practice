/**
 * 121. Best Time to Buy and Sell Stock
 * Difficulty: Easy
 
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Tags: Array, Dynamic Programming
 */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min_so_far = prices[0];   // First day's price
        int max_profit = 0;        // No transaction yet
        for(int i = 1; i < n; i++){
            int profit = prices[i] - min_so_far;   //  Use current min

            max_profit = Math.max(profit, max_profit);  // Update max

            min_so_far = Math.min(prices[i], min_so_far);  // Update min for NEXT iteration
        }

        return max_profit;
    }
}
