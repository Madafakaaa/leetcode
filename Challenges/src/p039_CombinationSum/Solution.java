package p039_CombinationSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(null, candidates, target);
        res = res.stream()
                .distinct()
                .collect(Collectors.toList());
        return res;
    }

    public void helper(List<Integer> used, int[] candidates, int target) {
        if (target == 0) {
            if (used == null) used = new ArrayList<>();
            Collections.sort(used);
            if (!res.contains(res)) res.add(used);
        } else if (target > 0) {
            if (used == null) used = new ArrayList<>();
            for (int i : candidates) {
                List<Integer> temp = new ArrayList<>(used);
                temp.add(i);
                helper(temp, candidates, target - i);
            }
        }
    }

}