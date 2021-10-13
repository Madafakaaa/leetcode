package p000_Interview;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/12 16:23
 */
public class Atoi {

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.atoi(null));
        System.out.println(atoi.atoi(""));
        System.out.println(atoi.atoi("0"));
        System.out.println(atoi.atoi("1"));
        System.out.println(atoi.atoi("10"));
        System.out.println(atoi.atoi("-0"));
        System.out.println(atoi.atoi("-1"));
        System.out.println(atoi.atoi("-10"));
        System.out.println(atoi.atoi("10A"));
        System.out.println(atoi.atoi("A10"));
        System.out.println(atoi.atoi("999999999999"));
        System.out.println(atoi.atoi("-10A"));
        System.out.println(atoi.atoi("-A10"));
        System.out.println(atoi.atoi("-99999999999999999"));
    }

    public Integer atoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        str = str.replaceAll(" ", "");
        char[] chars = str.toCharArray();
        int sign = 1;
        int index = 0;
        if (chars[index] == '+') {
            index++;
        } else if (chars[index] == '-') {
            index++;
            sign = -1;
        }
        int res = 0;
        while (index < chars.length) {
            if (!Character.isDigit(chars[index])) {
                break;
            }
            int temp = res;
            res = 10 * res + chars[index] - '0';
            index++;
        }
        return sign * res;
    }
}
