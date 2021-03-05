package p046_Permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        for (int n : nums) {
            numsList.add(n);
        }
        bfs(res, null, numsList);
        return res;
    }

    public void bfs(List<List<Integer>> res, List<Integer> list, List<Integer> nums) {
        if (list == null) list = new ArrayList<>();
        if (nums.isEmpty()) {
            res.add(list);
            return;
        }
        for (int i : nums) {
            List<Integer> newList = new ArrayList<>(list);
            List<Integer> newNums = new ArrayList<>(nums);
            newList.add(i);
            newNums.remove((Object) i);
            bfs(res, newList, newNums);
        }
    }
}