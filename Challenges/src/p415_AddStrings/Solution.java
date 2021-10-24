package p415_AddStrings;

class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() > num2.length()) {
            addStrings(num2, num1);
        }
        num1 = reverse(num1);
        num2 = reverse(num2);
        StringBuilder sb = new StringBuilder();
        int extra = 0;
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            int b = num2.charAt(i) - '0';
            int temp = (a + b + extra) % 10;
            extra = (a + b + extra) / 10;
            sb.append(temp);
        }
        for (int i = num1.length(); i < num2.length(); i++) {
            int b = num2.charAt(i) - '0';
            int temp = (b + extra) % 10;
            extra = (b + extra) / 10;
            sb.append(temp);
        }
        if (extra == 1) {
            sb.append(1);
        }
        return reverse(sb.toString());
    }

    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}