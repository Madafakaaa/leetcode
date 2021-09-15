package 剑指Offer.剑指Offer05_替换空格;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 1:03
 */
class Solution {
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }
}
