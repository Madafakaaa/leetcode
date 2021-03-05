package p062_UniquePaths;

class Solution {
    public int uniquePaths(int m, int n) {
        double m1 = getMul(m - 1), n1 = getMul(n - 1), mn1 = getMul(m + n - 2);
        return (int) Math.round((mn1 / (m1 * n1)));
    }

    public double getMul(int k) {
        if (k == 0) return 1;
        double res = 1;
        for (int i = 1; i <= k; i++) {
            res *= i;
        }
        return res;
    }
}