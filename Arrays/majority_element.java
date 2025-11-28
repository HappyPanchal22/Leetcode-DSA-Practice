//Boyer-Moore Voting Algorithm - Optimal Solution
class Solution {
    public int majorityElement(int[] nums) {
        //**Key property of Algorithm:** If majority element appears >n/2 times, 
        //it will have "excess votes" that can't be cancelled.

        // Phase 1: Find candidate
       int candidate = nums[0];
       int count = 1;
       for(int i = 1; i < nums.length; i++){
          if(count == 0){
            candidate = nums[i];
          }
          if(nums[i] == candidate){
            count ++;          //// Supporting vote
          }
          else{
            count--;        // Opposing vote (cancellation)
          }
       }
       return candidate;
    }
}
