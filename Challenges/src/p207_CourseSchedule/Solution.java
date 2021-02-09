package p207_CourseSchedule;

import java.util.*;

class Solution {

    public boolean res = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> preLists = new ArrayList<>();
        for(int i=0;i<numCourses;i++) preLists.add(new HashSet<Integer>());
        for(int[] pre : prerequisites)preLists.get(pre[0]).add(pre[1]);
        detectCycle(preLists,0);
        return res;
    }

    public void detectCycle(List<Set<Integer>> preLists, int i){

    }

}