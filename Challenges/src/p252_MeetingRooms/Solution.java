package p252_MeetingRooms;

import java.util.Arrays;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/20 15:49
 */
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
