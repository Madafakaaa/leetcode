package 剑指Offer.剑指Offer65_不用加减乘除做加法;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 14:51
 */
class Solution {
    public int add(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
}
