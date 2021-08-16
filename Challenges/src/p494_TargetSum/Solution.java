package p494_TargetSum;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array nums and an integer target.
 * <p>
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 * <p>
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 * <p>
 * Example 1:
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * <p>
 * Example 2:
 * Input: nums = [1], target = 1
 * Output: 1
 */
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        map.put(-nums[0], map.getOrDefault(nums[0], 0) + 1);
        for (int i = 1; i < nums.length; i++) {
            HashMap<Integer, Integer> newMap = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                newMap.put(entry.getKey() + nums[i], newMap.getOrDefault(entry.getKey() + nums[i], 0) + entry.getValue());
                newMap.put(entry.getKey() - nums[i], newMap.getOrDefault(entry.getKey() - nums[i], 0) + entry.getValue());
            }
            map = newMap;
        }
        return map.getOrDefault(target, 0);
    }
}