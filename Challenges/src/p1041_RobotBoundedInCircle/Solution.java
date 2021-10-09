package p1041_RobotBoundedInCircle;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/9 3:07
 */
class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, dir = 0;
        int[][] moves = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                dir = (dir + 1) % 4;
            }
            if (c == 'R') {
                dir = (dir + 3) % 4;
            }
            if (c == 'G') {
                x += moves[dir][1];
                y += moves[dir][0];
            }
        }
        return dir % 4 != 0 || (x == 0 && y == 0);
    }
}
