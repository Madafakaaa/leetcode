package 剑指Offer.剑指Offer56_数组中数字出现的次数;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 17:34
 */
class Solution {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int mask = 1;
        while ((mask & xor) == 0) {
            mask <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((mask & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
