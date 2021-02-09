package p073_SetMatrixZeroes;

import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> column = new HashSet<>();
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< matrix[0].length;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    column.add(j);
                }
            }
        }
        Iterator<Integer> rowIte = row.iterator();
        Iterator<Integer> colIte = column.iterator();
        while(rowIte.hasNext()){
            int rowIndex = rowIte.next();
            for(int i=0;i< matrix[0].length;i++){
                matrix[rowIndex][i] = 0;
            }
        }
        while(colIte.hasNext()){
            int colIndex = colIte.next();
            for(int i=0;i< matrix.length;i++){
                matrix[i][colIndex] = 0;
            }
        }
    }
}
