package p015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return result;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            // !!!!!
            while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[right] + nums[left] + nums[i] == 0) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[left], nums[right]);
                    result.add(temp);
                    left++;
                    right--;
                    // !!!!!
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // !!!!!
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[right] + nums[left] + nums[i] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}