package p013_RomanToInteger;

class Solution {
    public int romanToInt(String s) {
        int result = 0;
        StringBuffer sb = new StringBuffer(s);
        Integer[] numDict = new Integer[]{1000, 900, 800, 700, 600, 500, 400, 100, 90, 80, 70, 60, 50, 40, 10, 9, 8, 7, 6, 5, 4, 1};
        String[] romDict = new String[]{"M", "CM", "DCCC", "DCC", "DC", "D", "CD", "C", "XC", "LXXX", "LXX", "LX", "L", "XL", "X", "IX", "VIII", "VII", "VI", "V", "IV", "I"};
        int index = 0;
        while (sb.length() > 0 && index < numDict.length) {
            if (romDict[index].length() > sb.length()) {
                index++;
                continue;
            }
            if (sb.substring(0, romDict[index].length()).equals(romDict[index])) {
                result += numDict[index];
                sb.delete(0, romDict[index].length());
            } else {
                index++;
            }
        }
        return result;
    }
}