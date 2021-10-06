package p051_NQueens;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/7 1:00
 */
class Solution {

    public List<List<String>> res;
    public boolean[][] grid;
    public boolean[] col;
    public boolean[] diagL;
    public boolean[] diagR;
    public int n;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<List<String>>();
        grid = new boolean[n][n];
        col = new boolean[n];
        diagL = new boolean[2 * n - 1];
        diagR = new boolean[2 * n - 1];
        this.n = n;
        backtrack(0);
        return res;
    }

    public void backtrack(int layer) {
        if (layer == n) {
            res.add(construct(grid));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] || diagR[i + layer] || diagL[i - layer + n - 1]) {
                continue;
            }
            col[i] = true;
            diagL[i - layer + n - 1] = true;
            diagR[i + layer] = true;
            grid[layer][i] = true;
            backtrack(layer + 1);
            grid[layer][i] = false;
            col[i] = false;
            diagL[i - layer + n - 1] = false;
            diagR[i + layer] = false;
        }
    }

    public List<String> construct(boolean[][] grid) {
        List<String> res = new ArrayList<>();
        for (boolean[] row : grid) {
            StringBuilder sb = new StringBuilder();
            for (boolean b : row) {
                if (b) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

}































