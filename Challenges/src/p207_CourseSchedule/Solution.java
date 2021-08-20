package p207_CourseSchedule;

import java.util.ArrayList;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * <p>
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * <p>
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build a directed graph.
        // If any loop happens, then we cannot finish the courses. Using dfs to find loop in the graph.
        // 1. corner case: no prerequisites
        if (prerequisites.length == 0) {
            return true;
        }
        // 2. build graph. Index indicates current course,
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        // initial the graph
        for (int i = 0; i < numCourses; i++) {
            ArrayList<Integer> prereq = new ArrayList();
            graph[i] = prereq;
        }
        // fill the graph with values
        for (int i = 0; i < prerequisites.length; i++) {
            int[] cur = prerequisites[i];
            graph[cur[0]].add(cur[1]);
        }
        // 3. create visited to record current process.
        // If not yet visit, it is 0. Visiting (looking for loops) - 1. Visited and no loops - 2;
        int[] visited = new int[numCourses];
        // for loop to find
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfsCanFinish(i, visited, graph)) {
                return false;
            }
        }
        return true;
    }

    boolean dfsCanFinish(int cur, int[] visited, ArrayList[] graph) {
        if (visited[cur] == 2) {
            return true;
        }
        if (visited[cur] == 1) {
            // loop happens
            return false;
        }
        visited[cur] = 1;
        ArrayList<Integer> prereqs = graph[cur];
        for (int i = 0; i < prereqs.size(); i++) {
            if (!dfsCanFinish(prereqs.get(i), visited, graph)) {
                return false;
            }
        }
        visited[cur] = 2;
        return true;
    }
}
