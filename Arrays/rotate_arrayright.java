/**
 * 189. Rotate Array
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Tags: Array, Math, Two Pointers
 */

class Solution {
    public void reverse(int[] nums, int start, int end){
        int left = start;
        int right = end;

        while(left < right){
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;

            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {
        //LOGIC : **Right rotation by k steps:**
             // Last k elements move to the front
             // First n-k elements shift to the right
        int n = nums.length;

        k = k % n;            // to handle when k > n
      
        // Step 1: Reverse entire array
        reverse(nums, 0, n-1);

        // Step 2: Reverse first k elements
        reverse(nums, 0, k-1);

       // Step 3: Reverse remaining n-k elements
        reverse(nums, k, n-1);
    }
}
