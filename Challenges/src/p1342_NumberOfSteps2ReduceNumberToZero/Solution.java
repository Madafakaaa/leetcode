package p1342_NumberOfSteps2ReduceNumberToZero;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/15 10:07
 */
class Solution {
    public int numberOfSteps(int num) {
        int res = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                num -= 1;
            } else {
                num /= 2;
            }
            res++;
        }
        return res;
    }
}