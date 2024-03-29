package 剑指Offer.剑指Offer56_数组中数字出现的次数II;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 17:59
 */
class Solution {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
