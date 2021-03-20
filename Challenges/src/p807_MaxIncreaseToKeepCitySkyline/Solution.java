package p807_MaxIncreaseToKeepCitySkyline;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/20 13:20
 * <p>
 * In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there. We are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for different buildings). Height 0 is considered to be a building as well.
 * <p>
 * At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right, must be the same as the skyline of the original grid. A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance. See the following example.
 * <p>
 * What is the maximum total sum that the height of the buildings can be increased?
 * <p>
 * Example:
 * Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 * Output: 35
 * Explanation:
 * The grid is:
 * [ [3, 0, 8, 4],
 * [2, 4, 5, 7],
 * [9, 2, 6, 3],
 * [0, 3, 1, 0] ]
 * <p>
 * The skyline viewed from top or bottom is: [9, 4, 8, 7]
 * The skyline viewed from left or right is: [8, 7, 9, 3]
 * <p>
 * The grid after increasing the height of buildings without affecting skylines is:
 * <p>
 * gridNew = [ [8, 4, 8, 7],
 * [7, 4, 7, 7],
 * [9, 4, 8, 7],
 * [3, 3, 3, 3] ]
 */
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] top = new int[grid[0].length];
        int[] left = new int[grid.length];
        Integer temp;
        Integer i, j;
        for (i = 0; i < grid.length; i++) {
            temp = Integer.MIN_VALUE;
            for (j = 0; j < grid[0].length; j++) {
                temp = Math.max(temp, grid[i][j]);
            }
            left[i] = temp;
        }
        for (i = 0; i < grid[0].length; i++) {
            temp = Integer.MIN_VALUE;
            for (j = 0; j < grid.length; j++) {
                temp = Math.max(temp, grid[j][i]);
            }
            top[i] = temp;
        }
        temp = 0;
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                temp += Math.min(top[j], left[i]) - grid[j][i];
            }
        }
        return temp;
    }
}