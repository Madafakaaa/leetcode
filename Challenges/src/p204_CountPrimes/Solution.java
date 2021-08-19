package p204_CountPrimes;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example 1:
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * Example 2:
 * Input: n = 0
 * Output: 0
 * Example 3:
 * Input: n = 1
 * Output: 0
 */
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        if (n == 3) {
            return 1;
        }
        int res = 0;
        boolean[] composites = new boolean[n];
        composites[0] = true;
        composites[1] = true;
        for (int i = 4; i < n; i += 2) {
            composites[i] = true;
        }
        for (int i = 3; i < n; i += 2) {
            if (!composites[i]) {
                for (int j = 3 * i; j < n; j += 2 * i) {
                    composites[j] = true;
                }
            }
        }
        for (boolean composite : composites) {
            if (!composite) {
                res++;
            }
        }
        return res;
    }
}
