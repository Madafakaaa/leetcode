package p1827_MinimumOperationsToMakeTheArrayIncreasing;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/5/6 10:08
 * <p>
 * You are given an integer array nums (0-indexed). In one operation, you can choose an element of the array and increment it by 1.
 * <p>
 * For example, if nums = [1,2,3], you can choose to increment nums[1] to make nums = [1,3,3].
 * Return the minimum number of operations needed to make nums strictly increasing.
 * <p>
 * An array nums is strictly increasing if nums[i] < nums[i+1] for all 0 <= i < nums.length - 1. An array of length 1 is trivially strictly increasing.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1]
 * Output: 3
 * Explanation: You can do the following operations:
 * 1) Increment nums[2], so nums becomes [1,1,2].
 * 2) Increment nums[1], so nums becomes [1,2,2].
 * 3) Increment nums[2], so nums becomes [1,2,3].
 * Example 2:
 * <p>
 * Input: nums = [1,5,2,4,1]
 * Output: 14
 */
class Solution {
    public int minOperations(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 0;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= temp) {
                res += temp + 1 - nums[i];
                nums[i] = temp + 1;
            }
            temp = nums[i];
        }
        return res;
    }
}