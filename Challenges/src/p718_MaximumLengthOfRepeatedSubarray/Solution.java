package p718_MaximumLengthOfRepeatedSubarray;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/8 17:55
 */
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return 0;
        }
        int res = 0;
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
                res = 1;
            }
        }
        for (int i = 1; i < nums2.length; i++) {
            if (nums1[0] == nums2[i]) {
                dp[0][i] = 1;
                res = 1;
            }
        }
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
