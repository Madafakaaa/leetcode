package p198_HouseRobber;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int prevMax = 0;
            for (int j = 0; j < i - 1; j++) if (dp[j] > prevMax) prevMax = dp[j];
            dp[i] = nums[i] + prevMax;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}