package p812_LargestTriangleArea;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/19 1:36
 */
class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0d;
        double area;
        for (int i = 0; i < points.length - 2; ++i) {
            for (int j = i + 1; j < points.length - 1; ++j) {
                for (int k = j + 1; k < points.length; ++k) {
                    maxArea = Math.max(maxArea, area(points[i], points[j], points[k]));
                }
            }
        }
        return maxArea;
    }

    private double area(int[] a, int[] b, int[] c) {
        return Math.abs((a[0] * (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1])) / 2d);
    }
}
