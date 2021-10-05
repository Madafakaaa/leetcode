package p922_SortArrayByParityII;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/28 23:19
 */
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        if (nums.length <= 0 || nums.length % 2 == 1) {
            return nums;
        }
        int i = 0, j = 1;
        while (i < nums.length && j < nums.length) {
            while (i < nums.length && (nums[i] & 1) != 0) {
                i += 2;
            }
            while (j < nums.length && (nums[i] & 1) == 1) {
                j += 2;
            }
            if (i < nums.length && j < nums.length) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}
