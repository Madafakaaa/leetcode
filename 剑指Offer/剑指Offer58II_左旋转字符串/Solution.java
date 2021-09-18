package 剑指Offer.剑指Offer58II_左旋转字符串;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 14:16
 */
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
