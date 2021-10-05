package p040_CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/5 10:34
 */
class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length <= 0) {
            return res;
        }
        backtrack(candidates, target, res, new ArrayList<Integer>(), -1);
        return res;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index + 1; i < candidates.length; i++) {
            if (i > index + 1 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backtrack(candidates, target - candidates[i], res, list, i);
            list.remove(list.size() - 1);
        }
    }
}






















