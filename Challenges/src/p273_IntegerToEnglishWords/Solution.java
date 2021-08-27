package p273_IntegerToEnglishWords;

/**
 * Convert a non-negative integer num to its English words representation.
 * <p>
 * Example 1:
 * Input: num = 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 * Input: num = 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 * Input: num = 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 * Input: num = 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
class Solution {

    String[] lessThanTwenty = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    String[] lessThanHundred = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};


    public String numberToWords(int num) {
        String res = helper(num);
        res = res.replaceAll("  ", " ");
        return res.trim();
    }

    public String helper(int num) {
        if (num < 20) {
            return lessThanTwenty[num];
        } else if (num < 100) {
            return lessThanHundred[num / 10 - 2] + ((num % 10 == 0) ? "" : " " + lessThanTwenty[num % 10]);
        } else if (num < 1_000) {
            return helper(num / 100) + " Hundred " + ((num % 100 == 0) ? "" : helper(num % 100));
        } else if (num < 1_000_000) {
            return helper(num / 1_000) + " Thousand " + ((num % 1_000 == 0) ? "" : helper(num % 1_000));
        } else if (num < 1_000_000_000) {
            return helper(num / 1_000_000) + " Million " + ((num % 1_000_000 == 0) ? "" : helper(num % 1_000_000));
        } else {
            return helper(num / 1_000_000_000) + " Billion " + ((num % 1_000_000_000 == 0) ? "" : helper(num % 1_000_000_000));
        }
    }
}
