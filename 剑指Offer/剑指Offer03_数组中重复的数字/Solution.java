package 剑指Offer.剑指Offer03_数组中重复的数字;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 0:34
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        boolean[] found = new boolean[nums.length];
        for (int num : nums) {
            if (found[num]) {
                return num;
            }
            found[num] = true;
        }
        return -1;
    }
}
