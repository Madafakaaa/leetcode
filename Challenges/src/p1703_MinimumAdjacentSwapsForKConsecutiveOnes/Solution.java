package p1703_MinimumAdjacentSwapsForKConsecutiveOnes;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/6 11:09
 */
class Solution {
    public int minMoves(int[] nums, int k) {
        List<Integer> onePositions = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                onePositions.add(i);
            }
        }

        int[] preSum = new int[onePositions.size() + 1];

        for (int pos = 0; pos < onePositions.size(); ++pos) {
            preSum[pos + 1] = preSum[pos] + onePositions.get(pos);
        }

        int radius = k % 2 == 0 ? (k - 2) / 2 : (k - 1) / 2;

        int len = onePositions.size();
        int sum = Integer.MAX_VALUE;

        int lower = radius, upper = (k % 2 == 0) ? len - radius - 1 : len - radius;

        for (int i = lower; i < upper; ++i) {
            int left = preSum[i] - preSum[i - radius];

            int right = 0;
            if (k % 2 == 0) {
                right = preSum[i + radius + 2] - preSum[i + 1];
                sum = Math.min(right - left - onePositions.get(i), sum);
            } else {
                right = preSum[i + radius + 1] - preSum[i + 1];
                sum = Math.min(right - left, sum);
            }
        }

        return sum - (k % 2 == 0 ? (radius + 1) * (radius + 1) : radius * (radius + 1));
    }
}
