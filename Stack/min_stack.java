/**
 * 155. Min Stack
 * Difficulty: Medium
 * 
 * Time Complexity: O(1) for all operations
 * Space Complexity: O(n)
 * 
 * Tags: Stack, Design
 */

class MinStack {
    private Stack<Integer> st;
    private int min;

    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min){
            st.push(min);      // Save old min first!
            min = val;
        }
        st.push(val);
    }
    
    public void pop() {
        if(st.pop() == min){
            min = st.pop();  // Restore previous min
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}

