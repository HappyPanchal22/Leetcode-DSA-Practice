/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * Difficulty: Medium
 * 
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 * 
 * Tags: Array, Intervals, Sorting, Greedy
 */

class Solution {
    public int findMinArrowShots(int[][] points) {

        //Step-1 Sort the array by end time
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;   //Need atleast 1 arrow
        int arrowPos = points[0][1];     //Shoot at end of first balloon

        //Step-2 Process remaining balloons
        for(int i = 1; i < points.length; i++){
            //If current balloon start after arrow Position we need a new arrow
            if(points[i][0] > arrowPos){
                arrows++;
                arrowPos = points[i][1];
            }
        }
        return arrows;
    }
}
