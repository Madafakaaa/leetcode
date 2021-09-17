package p046_Permutations;

import java.util.ArrayList;
import java.util.Arrays;
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

    int[] nums;
    List<List<Integer>> res;
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        res = new ArrayList<>();
        used = new boolean[nums.length];
        Arrays.sort(this.nums);
        backtrack(0, new ArrayList<>());
        return res;
    }

    public void backtrack(int count, List<Integer> list) {
        if (count == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //We're sorting the array at first which will eventually help us to deal with duplicate values as duplicate values will be next to each other.
            //We are calling a function recursively which will always start it's traversal from first to end of our given array.
            //i. Inside that function at each step we try to fix a value for this stage and call it again recursively to fix other values for the next places. We use a boolean array to keep track of values already used.
            //ii. If we find a value already used we simply skip, or if we see our current value is matching with the previous one then two cases arise:
            //a) The boolean array for previous index says false , which means that value is already used as the first element of our permutation, then we skip as we need unique combination.
            //b) The boolean array for previous index says true, which means the present permutation we are building has used this value before , so we will simply continue adding this value to our list.
            //Whenever the list we are building is of the size of our array that means we have completed one permutation, so we add it to our result.
            // Judge whether current element is equal to previous element (nums[i] == nums[i - 1]) and previous element is used or not (used[i - 1]).
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            backtrack(count + 1, list);
            used[i] = false;
            list.remove(list.size() - 1);
        }

    }

}
