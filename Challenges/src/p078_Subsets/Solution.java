package p078_Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 */
class Solution {

    int[] nums;
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.res = new ArrayList<>();
        res.add(new ArrayList<>());
        add(new ArrayList<>(), 0);
        return res;
    }

    public void add(List<Integer> list, int index) {
        for (int i = index; i < nums.length; i++) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[i]);
            res.add(newList);
            add(newList, i + 1);
        }
    }

}