package p560_SubarraySumEqualsK;

/**
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * <p>
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 */
class Solution {

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp == k) {
                    res++;
                }
            }
        }
        return res;
    }

}