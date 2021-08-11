package p041_FirstMissingPositive;

/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * <p>
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 * <p>
 * Example 1:
 * Input: nums = [1,2,0]
 * Output: 3
 * <p>
 * Example 2:
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * <p>
 * Example 3:
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] b = new boolean[nums.length + 1];
        for (int num : nums) {
            if (num >= 0 && num < b.length) {
                b[num] = true;
            }
        }
        for (int i = 1; i < b.length; i++) {
            if (b[i] == false) {
                return i;
            }
        }
        return nums.length + 1;
    }
}