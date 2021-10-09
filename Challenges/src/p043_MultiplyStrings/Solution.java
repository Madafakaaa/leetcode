package p043_MultiplyStrings;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/9 14:19
 */
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int[] res = new int[num1.length() + num2.length()];
        for (int i = char1.length - 1; i >= 0; i--) {
            int n1 = char1[i] - '0';
            for (int j = char2.length - 1; j >= 0; j--) {
                int n2 = char2[j] - '0';
                res[i + j + 1] += n1 * n2;
                res[i + j] += res[i + j + 1] / 10;
                res[i + j + 1] = res[i + j + 1] % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            sb.append((char) (res[i] + '0'));
        }
        return sb.toString();
    }
}
