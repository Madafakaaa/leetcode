package 剑指Offer.剑指Offer42_连续子数组的最大和;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 0:16
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
