/**
 * 238. Product of Array Except Self
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) excluding output array
 * 
 * Tags: Array, Prefix Sum
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        // Pass 1: Build left products in answer array
        answer[0] = 1;
        for(int i = 1; i < n; i++){
            answer[i] = answer[i-1]*nums[i-1];
        }
        // Pass 2: Multiply by right products using ONE variable
        int right = 1;
        for(int i = n-1; i>= 0; i--){
            answer[i] = answer[i]*right;
            right = right*nums[i];
        }
        return answer;
    }
}
