package 剑指Offer.剑指Offer62_圆圈中最后剩下的数字;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 15:28
 */
class Solution {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
