/**
 * 274. H-Index
 * Difficulty: Medium
 * 
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 * 
 * Tags: Array, Sorting
 */

class Solution {
    public int hIndex(int[] citations) {
        // Step 1: Sort ascending
        Arrays.sort(citations);
        int n = citations.length;
        // Step 2: Traverse right to left
        for(int i = 0; i < n; i++){
            int papers = n - i;
            if(citations[i] >= papers){
                return papers;
            }
        }
        return 0;
    }
}
