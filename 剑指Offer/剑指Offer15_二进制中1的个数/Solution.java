package 剑指Offer.剑指Offer15_二进制中1的个数;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 15:37
 */
public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
