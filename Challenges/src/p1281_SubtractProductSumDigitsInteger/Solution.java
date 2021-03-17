package p1281_SubtractProductSumDigitsInteger;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/16 9:33
 */
class Solution {
    public int subtractProductAndSum(int n) {
        String number = String.valueOf(n);
        int sum = 0, mul = 1;
        for (int i = 0; i < number.length(); i++) {
            sum += Integer.parseInt(number.substring(i, i + 1));
            mul *= Integer.parseInt(number.substring(i, i + 1));
        }
        return mul - sum;
    }
}