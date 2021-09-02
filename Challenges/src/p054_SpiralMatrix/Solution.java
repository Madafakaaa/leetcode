package p054_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowStart = 0;
        int columnStart = 0;
        int rowEnd = matrix.length - 1;
        int columnEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd && columnStart <= columnEnd) {
            for (int i = columnStart; i <= columnEnd; i++) {
                res.add(matrix[rowStart][i]);
            }
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                res.add(matrix[i][columnEnd]);
            }

            if (rowStart == rowEnd || columnStart == columnEnd) break;
            for (int i = columnEnd - 1; i >= columnStart; i--) {
                res.add(matrix[rowEnd][i]);
            }
            for (int i = rowEnd - 1; i > rowStart; i--) {
                res.add(matrix[i][columnEnd]);
            }
            rowStart++;
            columnStart++;
            rowEnd--;
            columnEnd--;
        }
        return res;
    }

}
