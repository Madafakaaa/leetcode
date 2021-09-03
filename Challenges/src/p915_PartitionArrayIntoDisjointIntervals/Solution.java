package p915_PartitionArrayIntoDisjointIntervals;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/3 11:57
 */
class Solution {
    public int partitionDisjoint(int[] nums) {
        int length = nums.length;
        int[] minRight = new int[length];
        int tempMinRight = nums[length - 1];
        for (int i = length - 1; i >= 0; i--) {
            tempMinRight = Math.min(tempMinRight, nums[i]);
            minRight[i] = tempMinRight;
        }
        int tempMaxLeft = nums[0];
        for (int i = 0; i < length; i++) {
            tempMaxLeft = Math.max(tempMaxLeft, nums[i]);
            if (minRight[i + 1] >= tempMaxLeft) {
                return i;
            }
        }
        return -1;
    }
}


/**
 * class Solution {
 * public int partitionDisjoint(int[] nums) {
 * int curMax = nums[0];
 * int possibleMax = nums[0];
 * int length = 1;
 * <p>
 * for(int i=1; i<nums.length; i++)
 * {
 * if(nums[i] < curMax)
 * {
 * length = i+1;
 * curMax = possibleMax;
 * }
 * else
 * {
 * possibleMax = Math.max(possibleMax, nums[i]);
 * }
 * }
 * return length;
 * }
 * }
 */
