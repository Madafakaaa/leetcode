package p014_LongestCommonPrefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuffer result = new StringBuffer();
        int index = 0;
        while (true) {
            if (index >= strs[0].length()) {
                break;
            }
            char temp = strs[0].charAt(index);
            boolean equal = true;
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length()) {
                    equal = false;
                    break;
                }
                if (strs[i].charAt(index) != temp) {
                    equal = false;
                    break;
                }
            }
            if (equal) {
                result.append(temp);
            } else {
                break;
            }
            index++;
        }
        return result.toString();
    }
}