package 剑指Offer.剑指Offer04_二维数组中的查找;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 0:52
 */
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int heightStart = 0;
        int heightEnd = height - 1;
        int widthStart = 0;
        int widthEnd = width - 1;
        while (heightStart < height && matrix[heightStart][width - 1] < target) {
            heightStart++;
        }
        while (heightEnd >= 0 && matrix[heightEnd][0] > target) {
            heightEnd--;
        }
        while (widthStart < width && matrix[height - 1][widthStart] < target) {
            widthStart++;
        }
        while (widthEnd >= 0 && matrix[0][widthEnd] > target) {
            widthEnd--;
        }
        for (int i = heightStart; i <= heightEnd; i++) {
            for (int j = widthStart; j <= widthEnd; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}

















