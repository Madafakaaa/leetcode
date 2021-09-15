package 剑指Offer.剑指Offer13_机器人的运动范围;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 14:59
 */
class Solution {

    int k;
    int res;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.k = k;
        this.res = 0;
        this.visited = new boolean[m][n];
        dfs(0, 0);
        return res;
    }

    public void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        int temp = 0;
        int tempI = i;
        int tempJ = j;
        while (tempI != 0) {
            temp += tempI % 10;
            tempI = tempI / 10;
        }
        while (tempJ != 0) {
            temp += tempJ % 10;
            tempJ = tempJ / 10;
        }
        if (temp <= k) {
            res++;
            dfs(i + 1, j);
            dfs(i, j + 1);
        }
    }
}
