package QuickChallenges.p483_SmallestGoodBase;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/19 13:18
 */
class Solution {
    public String smallestGoodBase(String N) {
        long n = Long.parseLong(N);
        // Begin with base 2 (The Smallest base, largest power).
        for (int m = (int) (Math.log(n + 1) / Math.log(2)); m > 2; m--) {
            long baseL = (long) (Math.pow(n, 1.0 / m));
            long baseR = (long) (Math.pow(n, 1.0 / (m - 1)));
            while (baseL <= baseR) {
                long k = baseL + ((baseR - baseL) >> 1);
                long f = f(k, m);
                if (n == f) {
                    return String.valueOf(k);
                } else if (n < f) {
                    baseR = k - 1;
                } else {
                    baseL = k + 1;
                }
            }
        }
        return String.valueOf(n - 1);
    }

    /**
     * @param k base
     * @param m sie of digits
     * @return k^(m-1) + k^(m-2) + ... + k^1 + k^0
     */
    private long f(long k, int m) {
        long f = 0;
        for (int i = 0; i < m; i++) {
            f = f * k + 1;
        }
        return f;
    }

}
