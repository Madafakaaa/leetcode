package p039_CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * <p>
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 * <p>
 * Input: candidates = [2], target = 1
 * Output: []
 * Example 4:
 * <p>
 * Input: candidates = [1], target = 1
 * Output: [[1]]
 * Example 5:
 * <p>
 * Input: candidates = [1], target = 2
 * Output: [[1,1]]
 */
class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new ArrayList<>(150);
        bfs(candidates, target, 0, new ArrayList<>(candidates.length), 0);
        return result;
    }

    public void bfs(int[] candidates, int target, int index, List<Integer> combination, Integer sum) {
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            List<Integer> newCombination = new ArrayList<>(candidates.length);
            newCombination.addAll(combination);
            newCombination.add(candidates[i]);
            if (sum + candidates[i] == target) {
                result.add(newCombination);
                break;
            }
            bfs(candidates, target, i, newCombination, sum + candidates[i]);
        }
    }

}