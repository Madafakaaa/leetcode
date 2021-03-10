package p1480_RunningSumof1dArray;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/10 9:33
 */
class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) nums[i] += nums[i - 1];
        return nums;
    }
}