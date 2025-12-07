/**
 * 224. Basic Calculator
 * Difficulty: Hard
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Tags: String, Stack, Math, Recursion
 */

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;       // 1 for '+', -1 for '-'

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                //Build multi-digit number
                number = number * 10 + (c - '0');
            }
            else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }
            else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }
            else if(c == '('){
                // Save current state
                st.push(result);
                st.push(sign);
                // Reset for sub-expression
                result = 0;
                sign = 1;
            }
            else if(c == ')'){
                // Complete current number
                result += sign * number;
                number = 0;
                //Restore state
                result *= st.pop();      //Pop sign before '('
                result += st.pop();      //Pop result before '('
            }
        }
        result += sign * number;
        return result;
        
    }
}
