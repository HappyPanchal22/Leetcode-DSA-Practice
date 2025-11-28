class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 2;                 // First 2 elements always valid
        for(int i = 2; i < nums.length; i++){
             // Place element if: haven't placed 2 yet OR different from element 2 back
            if(k < 2 || nums[i] != nums[k-2]){
            nums[k] = nums[i];
            k++;
            }
        }
        return k;
    }  
}
