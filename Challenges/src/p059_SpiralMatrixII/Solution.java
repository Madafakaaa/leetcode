package p059_SpiralMatrixII;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/19 17:31
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int k = 1;
        int rowStart = 0;
        int columnStart = 0;
        int rowEnd = n - 1;
        int columnEnd = n - 1;
        while (rowStart <= rowEnd && columnStart <= columnEnd) {
            for (int i = columnStart; i <= columnEnd; i++) {
                res[rowStart][i] = k++;
            }
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                res[i][columnEnd] = k++;
            }
            if (rowStart == rowEnd || columnStart == columnEnd) break;
            for (int i = columnEnd - 1; i >= columnStart; i--) {
                res[rowEnd][i] = k++;
            }
            for (int i = rowEnd - 1; i > rowStart; i--) {
                res[i][columnStart] = k++;
            }
            rowStart++;
            columnStart++;
            rowEnd--;
            columnEnd--;
        }
        return res;
    }
}
