package p405_ConvertANumberToHexadecimal;

class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int hexDigit = num & 15;
            if (hexDigit < 10)
                sb.append(hexDigit);
            else
                sb.append((char) ('a' + hexDigit - 10));
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }
}