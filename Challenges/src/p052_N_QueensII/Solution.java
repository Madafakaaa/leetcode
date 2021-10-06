package p052_N_QueensII;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/7 1:20
 */
class Solution {
    public int res;
    public boolean[][] grid;
    public boolean[] col;
    public boolean[] diagL;
    public boolean[] diagR;
    public int n;

    public int totalNQueens(int n) {
        res = 0;
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
            res++;
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

}
















