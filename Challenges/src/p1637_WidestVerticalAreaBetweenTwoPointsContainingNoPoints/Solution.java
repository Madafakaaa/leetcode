package p1637_WidestVerticalAreaBetweenTwoPointsContainingNoPoints;

import java.util.Arrays;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/23 10:19
 * <p>
 * Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that no points are inside the area.
 * <p>
 * A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The widest vertical area is the one with the maximum width.
 * <p>
 * Note that points on the edge of a vertical area are not considered included in the area.
 */
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] xAxis = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            xAxis[i] = points[i][0];
        }
        Arrays.sort(xAxis);
        int res = 0;
        for (int i = 0; i < xAxis.length - 1; i++) {
            if (xAxis[i + 1] == xAxis[i]) {
                continue;
            }
            res = Math.max(res, xAxis[i + 1] - xAxis[i]);
        }
        return res;
    }
}
