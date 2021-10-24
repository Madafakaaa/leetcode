package p422_ValidWordSquare;

import java.util.List;

class Solution {
    public boolean validWordSquare(List<String> words) {
        // GET THE WIDTH AND HEIGHT
        int n = words.size();
        // GENERATE MATRIX
        char[][] matrix = new char[n][n];
        for (int i = 0; i < words.size(); i++) {
            // READ CHARS IN THE ROW
            char[] arr = words.get(i).toCharArray();
            // IF THE WIDTH IS LARGER THAN THE HEIGHT RETURN FALSE
            if (arr.length > n) {
                return false;
            }
            // INSERT CHARS INTO THE MATRIX
            for (int j = 0; j < arr.length; j++) {
                matrix[i][j] = arr[j];
            }
        }
        // COMPARE
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}