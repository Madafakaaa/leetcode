package p258_AddDigits;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/20 15:53
 */
class Solution {
    public int addDigits(int num) {
        while (num > 9) {
            int temp = 0;
            while (num > 0) {
                temp += num % 10;
                num /= 10;
            }
            num = temp;
        }
        return num;
    }
}
