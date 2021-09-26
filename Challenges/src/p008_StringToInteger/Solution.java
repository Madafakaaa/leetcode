package p008_StringToInteger;

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int res = 0;
        int sign = 1;
        if (chars[i] == '+') {
            i++;
        } else if (chars[i] == '-') {
            i++;
            sign = -1;
        }
        while (i < chars.length) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                if (res > (Integer.MAX_VALUE - chars[i] + '0') / 10) {
                    if (sign == 1) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                res = 10 * res + chars[i] - '0';
            } else {
                return sign * res;
            }
            i++;
        }
        return sign * res;
    }
}
