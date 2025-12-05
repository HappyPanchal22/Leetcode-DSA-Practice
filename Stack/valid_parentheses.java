/**
 * 20. Valid Parentheses
 * Difficulty: Easy
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Tags: String, Stack
 */

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            // If opening bracket, push to stack
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }
            // If closing bracket, check match
            else{
                // Edge case: closing bracket but stack is empty
                if(st.isEmpty()) return false;
                char top = st.pop();
                
                // Check if brackets match
                if ((c == ')' && top != '(') || (c == '}' && top != '{') ||
                (c == ']' && top != '[')) {
                    return false;
        }
    }
 }
     return st.isEmpty();
    }
}
