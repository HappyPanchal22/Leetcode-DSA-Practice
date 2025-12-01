/**
 * 55. Jump Game
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Tags: Array, Dynamic Programming, Greedy
 */

class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            // Check if current position is unreachable
            if(i > farthest){
                return false;
            }
            // Update farthest reachable
            farthest = Math.max(farthest, i + nums[i]);

            // Check if we can reach the end
            if(farthest >= n-1){
                return true;
            }
        }
        return true;
    }
}
