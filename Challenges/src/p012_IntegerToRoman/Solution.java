package p012_IntegerToRoman;

class Solution {
    public String intToRoman(int num) {
        StringBuffer result = new StringBuffer();
        int index = 0;
        Integer[] numDict = new Integer[]{1000, 900, 800, 700, 600, 500, 400, 100, 90, 80, 70, 60, 50, 40, 10, 9, 8, 7, 6, 5, 4, 1};
        String[] romDict = new String[]{"M", "CM", "DCCC", "DCC", "DC", "D", "CD", "C", "XC", "LXXX", "LXX", "LX", "L", "XL", "X", "IX", "VIII", "VII", "VI", "V", "IV", "I"};
        while (index < numDict.length && num > 0) {
            if (num >= numDict[index]) {
                result.append(romDict[index]);
                num -= numDict[index];
            } else {
                index++;
            }
        }
        return result.toString();
    }
}