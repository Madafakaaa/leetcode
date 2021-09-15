package 剑指Offer.剑指Offer21_调整数组顺序使奇数位于偶数前面;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 15:55
 */
class Solution {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int temp;
        boolean leftBoolean, rightBoolean;
        while (left < right) {
            leftBoolean = nums[left] % 2 == 0;
            rightBoolean = nums[right] % 2 == 1;
            if (leftBoolean && rightBoolean) {
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            } else if (leftBoolean) {
                right--;
            } else if (rightBoolean) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        return nums;
    }
}
