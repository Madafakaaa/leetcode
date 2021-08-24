package p149_MaxPointsOnALine;

import java.util.HashMap;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
 * <p>
 * Example 1:
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 * <p>
 * Example 2:
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * <p>
 * Definition for a point.
 * class Point {
 * int x;
 * int y;
 * Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; }
 * }
 * <p>
 * Definition for a point.
 * class Point {
 * int x;
 * int y;
 * Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; }
 * }
 * <p>
 * Definition for a point.
 * class Point {
 * int x;
 * int y;
 * Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; }
 * }
 * <p>
 * Definition for a point.
 * class Point {
 * int x;
 * int y;
 * Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; }
 * }
 * <p>
 * Definition for a point.
 * class Point {
 * int x;
 * int y;
 * Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; }
 * }
 * <p>
 * Definition for a point.
 * class Point {
 * int x;
 * int y;
 * Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; }
 * }
 */

/**
 * Definition for a point.
 * class Point {
 * int x;
 * int y;
 * Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; }
 * }
 */

/**
 * 题意：2维坐标系里有多个点Point，找到其中的一条直线，让这条指针上的点最多
 * 来自discuss vote 2nd
 * 注意：The above code takes care of parallel lines, since it is considering lines passing through one point at a time. Lines having the same slope and passing through one point are the same line.
 * 思路：第一个for会固定一个点，然后第二个for去遍历其它的点和这个点的组合。求斜率k的时候要分3种情况：1.j的坐标和i一样；2.i和j在同一条平行于y轴的线上；3.存在有效的斜率k
 *  --------------
 * 2021: 主要是注意一下edge case。 Time：O(N^2).
 */
public class Solution {
    public int maxPoints(int[][] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            //先固定一个点，再去遍历其它可能的点
            //遍历完一个点和其它所有点的组合之后，需要重置下面的这3个变量
            // key是直线的斜率，value是这个斜率直线上的点的数量
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
            //same X.暂存中间过程的结果。保存的是：当几个点是在同一条平行于y轴的直线上时，的点的数量
            int samex = 1;
            //same Point.暂存和一个点坐标一样的点的数量
            int samep = 0;
            //注意：这里必须是 j=0 而不是 j=i+1
            for (int j = i + 1; j < points.length; j++) {
                //i==j时为同一个点，需要找的是两个点之间的关系
                if (j != i) {
                    //两个点x和y坐标一样
                    if ((points[j][0] == points[i][0]) && (points[j][1] == points[i][1])) samep++;
                    //i和j在同一条平行于y轴的线上。因为下面除以(points[j].x - points[i].x)，所以这个被除数不能为0
                    if (points[j][0] == points[i][0]) {
                        samex++;
                        continue;
                    }
                    //强制转换成double，因为可能是小数
                    //直线斜率k
                    double k = (double) (points[j][1] - points[i][1]) / (double) (points[j][0] - points[i][0]);
                    if (k == 0.0 || k == -0.0) k = Math.abs(k);
                    //val+1，因为初始化为2(已经包括了i这个点了)，所以这个地方不是+2,而是+1
                    if (hm.containsKey(k)) hm.put(k, hm.get(k) + 1);
                        //初始化为2，因为一条直线上至少有2个点
                    else hm.put(k, 2);
                    //看是否update result，需要加上坐标一样的点
                    result = Math.max(result, hm.get(k) + samep);
                }
            }
            //之前的update是当斜率存在的情况，下面这个update只针对于一条垂直直线(即没有斜率)的情况
            result = Math.max(result, samex);//看是否update result
        }
        return result;

    }
}
