package NumberOfIslands;

import java.util.*;

class Solution {

    public int numIslands(char[][] grid) {
        if(grid.length==0){
            return 0;
        }
        if(grid[0].length==0){
            return 0;
        }

        int res = 0;
        for(int i=0;i< grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    clearGrid(grid, i, j);
                }
            }
        }
        return res;
    }

    public void clearGrid(char[][] grid, int i,int j){
        grid[i][j] = '0';
        if(j>0&&grid[i][j-1]=='1') clearGrid(grid, i, j-1);
        if(j<grid[0].length-1&&grid[i][j+1]=='1') clearGrid(grid, i, j+1);
        if(i>0&&grid[i-1][j]=='1') clearGrid(grid, i-1, j);
        if(i<grid.length-1&&grid[i+1][j]=='1') clearGrid(grid, i+1, j);
    }

}
