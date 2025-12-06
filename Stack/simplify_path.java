/**
 * 71. Simplify Path
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Tags: String, Stack
 */

class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] components = path.split("/");

        for(String comp : components){
            //Skip empty strings and current directory
            if(comp.isEmpty() || comp.equals(".")){
                continue;
            }
            //Go back one directory
            else if(comp.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
                // If stack empty, we're at root, can't go up
            }
            // Valid directory name (including "...", "...." etc)
            else{
                st.push(comp);
            }
        }
           // Build result from stack (bottom to top)
        StringBuilder result = new StringBuilder();
        for(String dir : st){
            result.append("/").append(dir);
        }
        // Edge case: if stack empty, return root "/"
        return result.length() > 0 ? result.toString() : "/";
    }
}
