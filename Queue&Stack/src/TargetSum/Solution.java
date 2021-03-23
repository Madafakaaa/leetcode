package TargetSum;

import java.util.HashMap;
import java.util.Iterator;

class Solution {

    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i : nums) {
            Iterator<Integer> itr = map.keySet().iterator();
            HashMap<Integer, Integer> newMap = new HashMap<>();

            while (itr.hasNext()) {
                int key = itr.next();
                newMap.put(key + i, newMap.getOrDefault(key + i, 0) + map.getOrDefault(key, 0));
                newMap.put(key - i, newMap.getOrDefault(key - i, 0) + map.getOrDefault(key, 0));
            }

            map.clear();
            map = newMap;
        }

        return map.getOrDefault(S, 0);
    }

}
