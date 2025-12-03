/**
 * 56. Merge Intervals
 * Difficulty: Medium
 * 
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 * 
 * Tags: Array, Intervals, Sorting
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        //Edge Case
        if(intervals.length <= 1) return intervals;

        //1.Sort the intervals by their start time
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0], b[0]));

        //2.Merge Overlapping intervals
        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);
        for(int[] interval : intervals){
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];
            
            // Check if overlapping
            if(nextStart <= currentEnd){
                // Merge: extend the end
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            }
            else{
                // No overlap: start new interval
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
         // Convert List to array
        return merged.toArray(new int[merged.size()][]);
    }
}
