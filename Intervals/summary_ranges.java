/**
 * 228. Summary Ranges
 * Difficulty: Easy
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Tags: Array, Intervals
 */

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        // Edge case: empty array
        if(nums.length == 0) return result;

        int start = 0;  // Start of current range
        for(int i = 0; i < nums.length; i++){
            // Check if next number breaks the sequence
            // (or we're at the end)
            if(i == nums.length - 1 || nums[i + 1] != nums[i] + 1){
                // Range ends here, add to result
                if(start == i){
                    // Single number
                    result.add(String.valueOf(nums[start]));
                }
                else{
                    // Range of numbers
                    result.add(nums[start] + "->" + nums[i]);
                }
                // Next range starts at next position
                start = i + 1;
            }
        }
       return result;
    }
}
