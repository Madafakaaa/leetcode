package p045_JumpGameII;

/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * You can assume that you can always reach the last index.
 * <p>
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * <p>
 * [1,2]
 */
class Solution {

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int current = 0, jump = 0, maxNextJump = nums[0], nextIndex = 0;
        while (maxNextJump < nums.length - 1) {
            for (int i = current + 1; i <= current + nums[current] && i < nums.length; i++) {
                if (i + nums[i] > maxNextJump) {
                    nextIndex = i;
                    maxNextJump = i + nums[i];
                }
            }
            current = nextIndex;
            jump++;
        }
        return jump + 1;
    }

}