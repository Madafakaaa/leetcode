package 剑指Offer.剑指Offer66_构建乘积数组;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 14:58
 */
class Solution {
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return a;
        }
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        left[0] = 1;
        for (int i = 1; i < a.length; i++) {
            left[i] = a[i - 1] * left[i - 1];
        }
        right[a.length - 1] = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            right[i] = a[i + 1] * right[i + 1];
        }
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
