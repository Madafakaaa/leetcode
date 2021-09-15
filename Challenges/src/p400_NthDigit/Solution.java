package p400_NthDigit;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 23:17
 */
class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        int num_digits_in_interval = 9;
        while (n - num_digits_in_interval > 0) {
            n -= num_digits_in_interval;
            digit += 1;
            num_digits_in_interval = 9 * ((int) Math.pow(10, digit - 1)) * digit;
        }
        int base = ((int) Math.pow(10, digit - 1));
        int number = base + (n - 1) / digit;
        char digit_in_number = String.valueOf(number).charAt((n - 1) % digit);
        return digit_in_number - '0';
    }
}
