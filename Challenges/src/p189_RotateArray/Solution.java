package p189_RotateArray;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * <p>
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        int index = 0;
        int[] res = new int[nums.length];
        for (int i = nums.length - k % nums.length; i < nums.length; i++) {
            res[index] = nums[i];
            index++;
        }
        for (int i = 0; i < nums.length - k % nums.length; i++) {
            res[index] = nums[i];
            index++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }
}
