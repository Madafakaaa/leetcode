package p056_MergeIntervals;

import java.util.Arrays;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * <p>
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            // create new interval
            if (intervals[i][0] > intervals[count][1]) {
                count++;
                intervals[count][0] = intervals[i][0];
                intervals[count][1] = intervals[i][1];
            }
            // merge
            if (intervals[i][0] <= intervals[count][1] && intervals[i][1] > intervals[count][1]) {
                intervals[count][1] = intervals[i][1];
            }
        }
        return Arrays.copyOfRange(intervals, 0, count + 1);
    }
}
