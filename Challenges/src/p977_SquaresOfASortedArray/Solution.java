package p977_SquaresOfASortedArray;

import java.util.Arrays;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/19 2:47
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
