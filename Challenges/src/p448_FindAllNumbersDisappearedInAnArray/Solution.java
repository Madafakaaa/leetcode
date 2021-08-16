package p448_FindAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 * <p>
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 * Input: nums = [1,1]
 * Output: [2]
 */
class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        int[] count = new int[nums.length];
        for (int num : nums) {
            if (num <= nums.length) {
                count[num - 1]++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (count[i] == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

}
