package p014_LongestCommonPrefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuffer result = new StringBuffer();
        int index = 0;
        outLoop:
        while (true) {
            if (index >= strs[0].length()) {
                break;
            }
            char temp = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length()) {
                    break outLoop;
                }
                if (strs[i].charAt(index) != temp) {
                    break outLoop;
                }
            }
            result.append(temp);
            index++;
        }
        return result.toString();
    }
}
