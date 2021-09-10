package p038_CountAndSay;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/9 15:55
 */
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String prev = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        Character temp = null;
        int count = 0;
        for (char c : prev.toCharArray()) {
            if (count == 0) {
                temp = c;
                count = 1;
                continue;
            }
            if (c == temp) {
                count++;
            } else {
                sb.append(count);
                sb.append(temp);
                temp = c;
                count = 1;
            }
        }
        sb.append(count);
        sb.append(temp);
        return sb.toString();
    }

}
