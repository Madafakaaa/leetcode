package p287_FindTheDuplicateNumber;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * <p>
 * There is only one repeated number in nums, return this repeated number.
 * <p>
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * <p>
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * <p>
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * <p>
 * Example 3:
 * Input: nums = [1,1]
 * Output: 1
 * <p>
 * Example 4:
 * Input: nums = [1,1,2]
 * Output: 1
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int[] set = new int[100001];
        for (int num : nums) {
            if (set[num] == 1) {
                return num;
            } else {
                set[num]++;
            }
        }
        return 0;
    }
}