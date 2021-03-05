package p300_LongestIncreasingSubsequence;

class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] count = new int[nums.length];
        count[0] = 1;
        int res = 0, temp;
        for (int i = 1; i < nums.length - 1; i++) {
            temp = 0;
            for (int j = 0; j < i; j++) if (nums[j] < nums[i]) temp = Math.max(temp, count[j]);
            count[i] = temp + 1;
            res = Math.max(res, count[i]);
        }
        return res;
    }

}