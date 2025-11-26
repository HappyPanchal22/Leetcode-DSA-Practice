/**
 * 88. Merge Sorted Array
 * Difficulty: Easy
 * 
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 * 
 * Tags: Array
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         //Merge from right to left instead of left to right! because the first array is has
        // extra spaces. If we start filling from left to right it will cause an overwrite 
        //for the unprocessed elements. IDEA: MERGE FROM RIGHT TO LEFT.
        int p1 = m - 1;    //points to last valid element in nums1
        int p2 = n - 1;     //points to last element in nums2
        int p = m + n - 1;   //points to last position in nums1 (where we'll write)
        
        // Main merge loop - compare and place larger element
        while(p1 >= 0 && p2 >= 0){
            if(nums2[p2] > nums1[p1]){
                nums1[p] = nums2[p2];
                p2--;
            }
            else{
                nums1[p] = nums1[p1];
                p1--;
            }
            p--;
        }
 
       // Only need to copy remaining elements from nums2
        // (nums1 elements are already in place)
        while(p2 >= 0){
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}
