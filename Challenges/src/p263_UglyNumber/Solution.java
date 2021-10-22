package p263_UglyNumber;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/20 15:57
 */
class Solution {
    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }
}
