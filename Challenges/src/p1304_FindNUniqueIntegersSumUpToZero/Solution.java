package p1304_FindNUniqueIntegersSumUpToZero;

/**
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 * <p>
 * Example 1:
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * <p>
 * Example 2:
 * Input: n = 3
 * Output: [-1,0,1]
 * <p>
 * Example 3:
 * Input: n = 1
 * Output: [0]
 */
class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n / 2; i++) {
            res[2 * i] = i + 1;
            res[2 * i + 1] = -(i + 1);
        }
        if (n % 2 == 1) {
            res[n - 1] = 0;
        }
        return res;
    }
}
