package p1119_RemoveVowelsFromString;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/26 11:21
 */
class Solution {
    public String removeVowels(String s) {
        s = s.replace("a", "");
        s = s.replace("e", "");
        s = s.replace("i", "");
        s = s.replace("o", "");
        s = s.replace("u", "");
        return s;
    }
}
