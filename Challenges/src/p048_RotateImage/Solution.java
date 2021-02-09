package p048_RotateImage;

class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] tempMatrix = new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                tempMatrix[i][j] = matrix[len-j-1][i];
            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                matrix[i][j] = tempMatrix[i][j];
            }
        }
    }
}