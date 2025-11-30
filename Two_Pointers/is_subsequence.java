/**
 * 392. Is Subsequence
 * Difficulty: Easy

 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Tags: String, Two Pointers, Dynamic Programming
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;  // pointer for s
        int j = 0;  //pointer for t
        while(j < t.length()){
            if(i < s.length() && s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();     // Only true if we matched ALL of s
    }
}
