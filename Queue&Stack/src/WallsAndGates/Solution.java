package WallsAndGates;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public final int[] coorX = new int[]{0, 0, 1, -1};
    public final int[] coorY = new int[]{1, -1, 0, 0};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(i * col + j);  //convert coordinate pair to index of the cell
                }
            }
        }
        while (!queue.isEmpty()) {
            int currGate = queue.poll();
            int gateX = currGate / col; // convert the index to coordinate pairs
            int gateY = currGate % col;
            for (int i = 0; i < 4; i++) {
                int roomX = gateX + coorX[i];
                int roomY = gateY + coorY[i];
                // within the boundary and  it is an empty room
                if (roomX >= 0 && roomX < row && roomY >= 0 && roomY < col && rooms[roomX][roomY] == Integer.MAX_VALUE) {
                    rooms[roomX][roomY] = rooms[gateX][gateY] + 1;
                    queue.offer(roomX * col + roomY);
                }
            }
        }
    }
}