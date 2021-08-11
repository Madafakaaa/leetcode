package p046_Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: [[1]]
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> numList = new ArrayList(nums.length);
        for (int num : nums) {
            numList.add(num);
        }
        dfs(res, new ArrayList<>(), numList);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, List<Integer> numList) {
        if (numList.isEmpty()) {
            res.add(list);
        } else {
            for (Integer num : numList) {
                List<Integer> newList = new ArrayList<>(list);
                List<Integer> newNumList = new ArrayList<Integer>(numList);
                newList.add(num);
                newNumList.remove(num);
                dfs(res, newList, newNumList);
            }
        }
    }
}