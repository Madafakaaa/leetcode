package 剑指Offer.剑指Offer17_打印从1到最大的n位数;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 15:48
 */
class Solution {
    public int[] printNumbers(int n) {
        int count = (int) (Math.pow(10, n) - 1);
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
