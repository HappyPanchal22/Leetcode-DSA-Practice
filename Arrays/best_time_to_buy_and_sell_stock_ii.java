/**
 * 122. Best Time to Buy and Sell Stock II
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Tags: Array, Dynamic Programming, Greedy
 */

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        for(int i = 0; i < n-1; i++){
            if(prices[i] < prices[i+1]){
                int profit = prices[i+1] - prices[i];    //loop through consecutive days
                maxProfit +=  profit;
            }
        }
        return maxProfit;
    }
}
