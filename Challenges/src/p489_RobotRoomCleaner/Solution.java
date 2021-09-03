package p489_RobotRoomCleaner;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 * // Returns true if the cell in front is open and robot moves into the cell.
 * // Returns false if the cell in front is blocked and robot stays in the current cell.
 * public boolean move();
 * <p>
 * // Robot will stay in the same cell after calling turnLeft/turnRight.
 * // Each turn will be 90 degrees.
 * public void turnLeft();
 * public void turnRight();
 * <p>
 * // Clean the current cell.
 * public void clean();
 * }
 */

class Solution {

    Set<Pair> visited;
    int[][] dirs;
    Robot robot;

    public void cleanRoom(Robot robot) {
        this.visited = new HashSet<>();
        this.dirs = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        this.robot = robot;
        backtrack(0, 0, 0);
    }

    public void backtrack(int x, int y, int dir) {
        // clean current cell
        this.robot.clean();
        // mark current call as visited
        visited.add(new Pair(x, y));
        for (int i = 0; i < 4; i++) {
            if (!visited.contains(new Pair(x + dirs[(i + dir) % 4][0], y + dirs[(i + dir) % 4][1])) && robot.move()) {
                backtrack(x + dirs[(i + dir) % 4][0], y + dirs[(i + dir) % 4][1], (i + dir) % 4);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }

}
