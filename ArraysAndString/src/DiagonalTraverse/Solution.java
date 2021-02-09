package DiagonalTraverse;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[0];
        }
        Integer[][] reorderedMatrix = new Integer[matrix.length][matrix.length+ matrix[0].length-1];
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< matrix[0].length;j++){
                reorderedMatrix[i][i+j] = matrix[i][j];
            }
        }
        int[] result = new int[matrix.length*matrix[0].length];
        boolean up = true;
        int index = 0;
        for(int i=0;i<matrix.length+ matrix[0].length-1;i++){
            if(up){
                for(int j=matrix.length-1;j>=0;j--){
                    if(reorderedMatrix[j][i]!=null){
                        result[index] = reorderedMatrix[j][i];
                        index++;
                    }
                }
            }else{
                for(int j=0;j<matrix.length;j++){
                    if(reorderedMatrix[j][i]!=null){
                        result[index] = reorderedMatrix[j][i];
                        index++;
                    }
                }
            }
            up = !up;
        }
        return result;
    }

}