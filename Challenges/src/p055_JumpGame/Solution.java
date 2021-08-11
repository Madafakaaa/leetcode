package p055_JumpGame;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 */
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;
        if (nums[0] >= nums.length - 1) return true;
        int currentIndex = 0, maxJump = nums[0], nextIndex = 0;
        while (maxJump < nums.length - 1) {
            for (int i = currentIndex + 1; i <= currentIndex + nums[currentIndex] && i < nums.length; i++) {
                if (maxJump < i + nums[i]) {
                    nextIndex = i;
                    maxJump = i + nums[i];
                }
            }
            if (nextIndex == currentIndex) {
                return false;
            }
            currentIndex = nextIndex;
        }
        return true;
    }
}