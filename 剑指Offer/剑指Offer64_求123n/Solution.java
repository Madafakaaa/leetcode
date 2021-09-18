package 剑指Offer.剑指Offer64_求123n;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 14:49
 */
class Solution {
    public int sumNums(int n) {
        if (n <= 1) {
            return n;
        }
        return sumNums(n - 1) + n;
    }
}
