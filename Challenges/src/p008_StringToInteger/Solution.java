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
                int temp = res;
                res = 10 * res + chars[i] - '0';
                if (res / 10 != temp) {
                    if (sign == 1) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                return sign * res;
            }
            i++;
        }
        return sign * res;
    }
}
