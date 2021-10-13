package p000_Interview;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/12 16:07
 */
public class Solution5 {

    public static void main(String[] args) {
        Solution5 s = new Solution5();
        System.out.println(s.integerToString(1));
        System.out.println(s.integerToString(26));
        System.out.println(s.integerToString(27));
        System.out.println(s.integerToString(52));
        System.out.println(s.integerToString(78));

        System.out.println(s.stringToInteger("A"));
        System.out.println(s.stringToInteger("Z"));
        System.out.println(s.stringToInteger("AA"));
        System.out.println(s.stringToInteger("AZ"));
        System.out.println(s.stringToInteger("BZ"));
//        for (int i = 0; i < 100; i++) {
//            System.out.println(s.stringToInteger(s.integerToString(i)));
//        }
        System.out.println(s.stringToInteger(s.integerToString(1000000000)));
        System.out.println(s.stringToInteger("ABCDEFGHIJKLMN"));
    }

    public String integerToString(int num) {
        if (num <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            char newChar = (char) ((num - 1) % 26 + 'A');
            sb.append(newChar);
            num = (num - 1) / 26;
        }
        return sb.reverse().toString();
    }

    public int stringToInteger(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        int res = 0;
        for (char c : str.toCharArray()) {
            if (c < 'A' || c > 'Z') {
                return -1;
            }
            int temp = res;
            res = 26 * res + c - 'A' + 1;
            if (res / 26 != temp) {
                return Integer.MAX_VALUE;
            }
        }
        return res;
    }

}
