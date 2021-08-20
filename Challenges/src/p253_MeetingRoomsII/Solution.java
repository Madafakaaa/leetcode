package p253_MeetingRoomsII;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 * <p>
 * Example 1:
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * <p>
 * Example 2:
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        /**
         0, 5, 15
         10, 20, 30
         **/
        Arrays.sort(starts);
        Arrays.sort(ends);
        int endI = 0;
        int rooms = 0;
        for (int startI = 0; startI < intervals.length; startI++) {
            if (starts[startI] < ends[endI]) {
                rooms++;
            } else {
                endI++;
            }
        }
        return rooms;
    }
}
