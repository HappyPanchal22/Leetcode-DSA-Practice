/**
 * 125. Valid Palindrome
 * Difficulty: Easy
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Tags: String, Two Pointers
 */

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        //s = s.toLowerCase();     --- this creates an extra string array so takes O(n) space
        while(left < right){
             // Step 1: Skip non-alphanumeric from left
             while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
             }

            // Step 2: Skip non-alphanumeric from right
             while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
             }
             // Step 3: Compare characters (case-insensitive)
             char leftChar = Character.toLowerCase(s.charAt(left));
             char rightChar = Character.toLowerCase(s.charAt(right));
             if(leftChar != rightChar){
                return false;
             }
             // Step 4: Move pointers inward
             left++;
             right--;
        }
        return true;
    }
}
