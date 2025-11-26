/**
 * 26. Remove Duplicates from Sorted Array
 * Difficulty: Easy
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Tags: Array
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        // k pointer is used to track where to place next unique element.
        // i pointer is used to scan through the array
        // IDEA : duplicates are always adjacent because of the sorted array property
      int k = 1;     //First element is always unique, that's why k starts with 1.
      for(int i = 1; i < nums.length; i++){
        if(nums[i] != nums[i-1]){
            nums[k] = nums[i];
            k++;
        }
      }
      return k;
    }
}
