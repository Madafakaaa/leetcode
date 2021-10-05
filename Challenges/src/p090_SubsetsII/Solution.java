package p090_SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/5 0:05
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(nums, list, result, 0);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> list, List<List<Integer>> result, int index) {
        if (index > nums.length) {
            return;
        }
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, list, result, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
