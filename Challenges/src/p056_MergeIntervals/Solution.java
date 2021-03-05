package p056_MergeIntervals;

import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] res = new int[intervals.length][2];
        int index = 0;
        int tempMin = intervals[0][0];
        int tempMax = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= tempMax && intervals[i][1] > tempMax) {
                tempMax = intervals[i][1];
            } else if (intervals[i][0] > tempMax) {
                res[index][0] = tempMin;
                res[index][1] = tempMax;
                index++;
                tempMin = intervals[i][0];
                tempMax = intervals[i][1];
            }
        }
        res[index][0] = tempMin;
        res[index][1] = tempMax;
        index++;
        return Arrays.copyOf(res, index);
    }
}