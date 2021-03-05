package p046_MultiplyStrings;

class Solution {
    public String multiply(String num1, String num2) {
        Integer int1 = Integer.valueOf(num1);
        Integer resInt = 0;
        for (int i = 0; i < num2.length(); i++) {
            resInt += int1 * Integer.valueOf(num2.charAt(num2.length() - 1 - i));
        }
        String res = String.valueOf(resInt);
        return res;
    }
}