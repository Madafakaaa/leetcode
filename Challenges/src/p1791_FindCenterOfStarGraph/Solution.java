package p1791_FindCenterOfStarGraph;

import java.util.HashMap;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/20 9:46
 */
class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            for (int node : edge) {
                map.put(node, map.getOrDefault(node, 0) + 1);
            }
        }
        int nodeNum = map.size();
        for (Integer node : map.keySet()) {
            if (map.getOrDefault(node, 0) == nodeNum - 1) {
                return node;
            }
        }
        return 0;
    }

    public int findCenter2(int[][] edges) {
        if (edges[0][0] == edges[1][0]) {
            return edges[0][0];
        }
        if (edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }
        if (edges[0][1] == edges[1][0]) {
            return edges[0][1];
        }
        if (edges[0][1] == edges[1][1]) {
            return edges[0][1];
        }
        return 0;
    }
}