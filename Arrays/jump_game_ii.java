/**
 * 45. Jump Game II
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Tags: Array, Dynamic Programming, Greedy
 */

class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int n = nums.length;
        int farthest = 0;      // farthest we can reach overall
        int currentEnd = 0;    // end of current "level"
        for(int i = 0; i < n - 1; i++){
            // Update farthest reachable
            farthest = Math.max(farthest, i + nums[i]);
            if(i == currentEnd){
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
}
