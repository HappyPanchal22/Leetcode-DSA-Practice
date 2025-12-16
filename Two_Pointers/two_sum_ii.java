/**
 * 167. Two Sum II - Input Array Is Sorted
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Tags: Array, Two Pointers, Binary Search
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;     // Start at index 0 (first element)
        int right = numbers.length - 1;   // Start at last valid index
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum > target){
                right--;       // Sum too big, need smaller number
            }
            else if(sum < target){
                left++;     // Sum too small, need bigger number
            }
            else{
                // Found it! Convert to 1-indexed
                return new int[]{left + 1,right + 1};
            }
        }
        return new int[]{};
    }
}
