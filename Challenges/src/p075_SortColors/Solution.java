package p075_SortColors;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <p>
 * You must solve this problem without using the library's sort function.
 * <p>
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * <p>
 * Example 3:
 * Input: nums = [0]
 * Output: [0]
 * <p>
 * Example 4:
 * Input: nums = [1]
 * Output: [1]
 */
class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}