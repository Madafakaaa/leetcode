package p1615_MaximalNetworkRank;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/3 14:12
 */
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] map = new int[n];
        boolean[][] connected = new boolean[n][n];
        for (int[] road : roads) {
            map[road[0]] += 1;
            map[road[1]] += 1;
            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
        }
        int max = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = i + 1; j < map.length; j++) {
                if (connected[i][j]) {
                    max = Math.max(max, map[i] + map[j] - 1);
                } else {
                    max = Math.max(max, map[i] + map[j]);
                }
            }
        }

        return max;
    }
}
