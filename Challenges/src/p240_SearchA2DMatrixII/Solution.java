package p240_SearchA2DMatrixII;

/**
 * Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * <p>
 * Example 1:
 * Input: matrix = [
 * [1,4,7,11,15],
 * [2,5,8,12,19],
 * [3,6,9,16,22],
 * [10,13,14,17,24],
 * [18,21,23,26,30]
 * ],
 * target = 5
 * Output: true
 * <p>
 * Example 2:
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * Output: false
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int hs = 0, ws = 0, he = matrix.length, we = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                he = i;
            }
            if (matrix[i][matrix[0].length - 1] < target) {
                hs = i + 1;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] > target) {
                we = i;
            }
            if (matrix[matrix[0].length - 1][i] < target) {
                ws = i + 1;
            }
        }
        for (int i = hs; i < he; i++) {
            for (int j = ws; j < we; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
