package 剑指Offer.剑指Offer53_n中缺失的数字;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 14:33
 */
class Solution {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
