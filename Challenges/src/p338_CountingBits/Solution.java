package p338_CountingBits;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * <p>
 * Example 1:
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * <p>
 * Example 2:
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 */
class Solution {
    public int[] countBits(int n) {
        if (n == 0) {
            return new int[]{0};
        }
        if (n == 1) {
            return new int[]{0, 1};
        }
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        int i = 2;
        while (i <= n) {
            int tempI = i;
            while (i <= n && i < 2 * tempI) {
                res[i] = res[i - tempI] + 1;
                i++;
            }
        }
        return res;
    }
}
