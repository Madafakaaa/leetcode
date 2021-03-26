package p1329_SortTheMatrixDiagonally;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/24 11:37
 * A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction
 * until reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].
 * <p>
 * Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
 */
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int height = mat.length, width = mat[0].length;
        ArrayList<Integer>[] lines = new ArrayList[height + width - 1];
        int index = 0;
        for (int i = 0; i < height; i++) {
            ArrayList<Integer> newLine = new ArrayList<>();
            int x = 0, y = i;
            while (x < width && y < height) {
                newLine.add(mat[y][x]);
                x++;
                y++;
            }
            Collections.sort(newLine);
            lines[index] = newLine;
            index++;
        }
        for (int i = 1; i < width; i++) {
            ArrayList<Integer> newLine = new ArrayList<>();
            int x = i, y = 0;
            while (x < width && y < height) {
                newLine.add(mat[y][x]);
                x++;
                y++;
            }
            Collections.sort(newLine);
            lines[index] = newLine;
            index++;
        }
        index = 0;
        for (int i = 0; i < height; i++) {
            ArrayList<Integer> line = lines[index];
            int x = 0, y = i;
            int temp = 0;
            while (x < width && y < height) {
                mat[y][x] = line.get(temp);
                x++;
                y++;
                temp++;
            }
            index++;
        }
        for (int i = 1; i < width; i++) {
            ArrayList<Integer> line = lines[index];
            int x = i, y = 0;
            int temp = 0;
            while (x < width && y < height) {
                mat[y][x] = line.get(temp);
                x++;
                y++;
                temp++;
            }
            index++;
        }
        return mat;
    }
}
