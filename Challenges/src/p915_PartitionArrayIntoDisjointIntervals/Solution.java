package p915_PartitionArrayIntoDisjointIntervals;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/3 11:57
 */
class Solution {
    public int partitionDisjoint(int[] nums) {
        int leftmax = nums[0];
        int maxInRun = nums[0];
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxInRun) {
                maxInRun = nums[i];
            } else if (nums[i] < leftmax) {
                ans = i;
                leftmax = maxInRun;
            }
        }
        return ans + 1;
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
