package p210_CourseScheduleII;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        if (res.size() != numCourses) {
            return new int[0];
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}


/**
 * class Solution {
 * public int[] findOrder(int numCourses, int[][] prerequisites) {
 * int n = numCourses;
 * List<Integer>[] dependents = new List[n];
 * for( int i = 0; i < n; i++)
 * dependents[i] = new ArrayList<>();
 * int[] dependency = new int[n];
 * <p>
 * for( int[] p : prerequisites){
 * dependents[p[1]].add(p[0]);
 * dependency[p[0]]++;
 * }
 * <p>
 * // get courses with no prerequisite
 * int[] order = new int[n];
 * int k = 0;
 * for( int i = 0; i < n; i++){
 * if(dependency[i] == 0)
 * order[k++] = i;
 * }
 * <p>
 * // taking the courses
 * int i = 0;
 * while( i < k){
 * for( int j : dependents[order[i]]){
 * dependency[j]--;
 * if( dependency[j] == 0)
 * order[k++] = j;
 * }
 * i++;
 * }
 * <p>
 * if( k == n)
 * return order;
 * return new int[0];
 * }
 * }
 */













