package p238_ProductOfArrayExceptSelf;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * <p>
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int[] leftProduct = new int[length];
        int[] rightProduct = new int[length];
        leftProduct[0] = nums[0];
        for (int i = 1; i < length; i++) {
            leftProduct[i] = nums[i] * leftProduct[i - 1];
        }
        rightProduct[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightProduct[i] = nums[i] * rightProduct[i + 1];
        }
        res[0] = rightProduct[1];
        res[length - 1] = leftProduct[length - 2];
        for (int i = 1; i < length - 1; i++) {
            res[i] = rightProduct[i + 1] * leftProduct[i - 1];
        }
        return res;
    }
}