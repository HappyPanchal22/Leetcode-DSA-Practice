/**
 * 150. Evaluate Reverse Polish Notation
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Tags: Array, Stack, Math
 */

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String token : tokens){
            if(isOperator(token)){
                //Pop two operands (order matters)
                int b = st.pop();
                int a = st.pop();

                //Apply Opertor
                int result = applyOperator(a, b, token);
                st.push(result);
            } else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();      //Final answer
    }
    private boolean isOperator(String token){
        return token.equals("+") || token.equals("-") || 
        token.equals("*") || token.equals("/");
    }

    private int applyOperator(int a, int b, String op){
        switch(op){
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: return 0;
        }
    }
}
