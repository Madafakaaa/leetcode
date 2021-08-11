package p048_RotateImage;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 */
class Solution {
    public void rotate(int[][] matrix) {
        reverseByDiagonal(matrix);
        reverseByMidline(matrix);
    }

    public void reverseByDiagonal(int[][] matrix) {
        int a = matrix.length;
        Integer temp = 0;
        for (int i = 0; i < a; i++) {
            for (int j = i + 1; j < a; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reverseByMidline(int[][] matrix) {
        int a = matrix.length;
        Integer temp = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a / 2; j++) { // j < a / 2 !!
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][a - 1 - j];
                matrix[i][a - 1 - j] = temp;
            }
        }
    }
}