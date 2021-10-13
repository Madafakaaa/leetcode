package p253_MeetingRoomsII;

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
        int shareNum = 0;
        int startIndex = 0;
        int endIndex = 0;
        while (startIndex < intervals.length && endIndex < intervals.length) {
            if (starts[startIndex] < ends[endIndex]) {
                startIndex++;
            } else {
                shareNum++;
                startIndex++;
                endIndex++;
            }
        }
        return intervals.length - shareNum;
    }
}
