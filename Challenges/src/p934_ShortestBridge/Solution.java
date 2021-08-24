package p934_ShortestBridge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In a given 2D binary array grid, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
 * <p>
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 * <p>
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 * <p>
 * Example 1:
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 * Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 */
class Solution {

    int[][] grid;
    int n;
    Queue<int[]> queue;
    boolean[][] visited;

    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.queue = new LinkedList();
        this.visited = new boolean[n][n];
        outerLoop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfsFlip(i, j);
                    break outerLoop;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (temp[0] < 0 || temp[1] < 0 || temp[0] >= n || temp[1] >= n || (temp[2] > 0 && visited[temp[0]][temp[1]])) {
                continue;
            }
            if (grid[temp[0]][temp[1]] == 1) {
                return temp[2] - 1;
            }
            visited[temp[0]][temp[1]] = true;
            queue.add(new int[]{temp[0] - 1, temp[1], temp[2] + 1});
            queue.add(new int[]{temp[0] + 1, temp[1], temp[2] + 1});
            queue.add(new int[]{temp[0], temp[1] - 1, temp[2] + 1});
            queue.add(new int[]{temp[0], temp[1] + 1, temp[2] + 1});
        }
        return 0;
    }

    public void dfsFlip(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = -1;
        queue.add(new int[]{i, j, 0});
        visited[i][j] = true;
        dfsFlip(i - 1, j);
        dfsFlip(i + 1, j);
        dfsFlip(i, j - 1);
        dfsFlip(i, j + 1);
    }
}
