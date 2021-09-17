package p047_PermutationsII;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/16 12:14
 */
class Solution {

    int[] nums;
    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        res = new ArrayList<>();
        backtrack(0, new ArrayList<>());
        return res;
    }

    public void backtrack(int count, List<Integer> list) {
        if (count == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 11) {
                list.add(nums[i]);
                nums[i] = 11;
                backtrack(count + 1, list);
                nums[i] = list.get(list.size() - 1);
                list.remove(list.size() - 1);
            }
        }

    }

}
