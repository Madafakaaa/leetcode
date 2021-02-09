package p008_StringToInteger;

class Solution {
    public int myAtoi(String str) {
        // empty string
        if(str == null || str.trim().length() == 0){
            return 0;
        }
        int sign = 1, result = 0, i = 0;
        // trim the str
        while(str.charAt(i) == ' ') {
            i++;
        }
        // read the sign
        if(str.charAt(i) == '-' || str.charAt(i) == '+'){
            sign = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        while(i < str.length()){
            // check if the character is digit
            int digit = str.charAt(i) - '0';
            if(digit < 0 || digit  > 9){
                break;
            }
            // detect overflow !!!
            if(result > (Integer.MAX_VALUE - digit) / 10){
                return sign == -1 ? Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return result * sign;
    }
}
