package p207_CourseSchedule;

import java.util.*;

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
        int[] inDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> postRequisites = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            List<Integer> postRequisite = postRequisites.getOrDefault(prerequisite[1], new ArrayList<Integer>());
            postRequisite.add(prerequisite[0]);
            postRequisites.put(prerequisite[1], postRequisite);
        }
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        boolean hasNewCourse = true;
        while (hasNewCourse) {
            hasNewCourse = false;
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == -1) {
                    continue;
                }
                if (inDegree[i] == 0) {
                    queue.add(i);
                    inDegree[i] = -1;
                    hasNewCourse = true;
                }
            }
            while (!queue.isEmpty()) {
                int finishedCourse = queue.poll();
                res.add(finishedCourse);
                List<Integer> postRequisite = postRequisites.getOrDefault(finishedCourse, new ArrayList<Integer>());
                for (Integer post : postRequisite) {
                    inDegree[post]--;
                }
            }
        }
        return res.size() == numCourses;
    }
}
























