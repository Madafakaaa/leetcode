package p057_InsertInterval;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/19 17:21
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //move until new Interval collides
        //merge nwInterval {}
        //move remaining elements
        List<int[]> result = new ArrayList<>();
        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while (i < intervals.length) {
            result.add(intervals[i++]);
        }

        return result.toArray(new int[result.size() - 1][2]);


    }
}
