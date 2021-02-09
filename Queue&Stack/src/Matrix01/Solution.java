package Matrix01;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        int height = matrix.length;
        int width = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    res[i][j] = 0;
                    queue.add(new int[]{i, j});
                }else{
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] startPoint = queue.poll();
            int x = startPoint[0], y = startPoint[1];
            if(x>0&&res[x-1][y]>(res[x][y]+1)){
                res[x-1][y] = res[x][y]+1;
                queue.add(new int[]{x-1, y});
            }
            if(x<height-1&&res[x+1][y]>(res[x][y]+1)){
                res[x+1][y] = res[x][y]+1;
                queue.add(new int[]{x+1, y});
            }
            if(y>0&&res[x][y-1]>(res[x][y]+1)){
                res[x][y-1] = res[x][y]+1;
                queue.add(new int[]{x, y-1});
            }
            if(y<width-1&&res[x][y+1]>(res[x][y]+1)){
                res[x][y+1] = res[x][y]+1;
                queue.add(new int[]{x, y+1});
            }
        }
        return res;
    }
}
