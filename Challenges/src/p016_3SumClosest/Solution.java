package p016_3SumClosest;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 10000;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (Math.abs(nums[right] + nums[left] + nums[i] - target) < Math.abs(result - target)) {
                    result = nums[right] + nums[left] + nums[i];
                }
                if (nums[right] + nums[left] + nums[i] == target) {
                    return target;
                } else if (nums[right] + nums[left] + nums[i] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}