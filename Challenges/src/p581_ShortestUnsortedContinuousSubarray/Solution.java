package p581_ShortestUnsortedContinuousSubarray;

import java.util.Arrays;

class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        if (Arrays.equals(sortedNums, nums)) return 0;
        int left = 0, right = nums.length - 1;
        while (left < right && nums[left] == sortedNums[left]) left++;
        while (left < right && nums[right] == sortedNums[right]) right--;
        return 1 + right - left;
    }

}