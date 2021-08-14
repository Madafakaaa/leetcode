package p279_PerfectSquares;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * <p>
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 * <p>
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
class Solution {

    public int numSquares(int n) {
        int[] nums = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.MAX_VALUE;
        }
        int[] sqrs = new int[(int) Math.sqrt(n) + 1];
        for (int i = 0; i < sqrs.length; i++) {
            nums[i * i] = 1;
            sqrs[i] = (i + 1) * (i + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) continue;
            int min = nums[i];
            for (int s : sqrs) {
                if (i - s > 0) {
                    min = Integer.min(min, nums[i - s] + 1);
                } else {
                    break;
                }
            }
            nums[i] = min;
        }

        return nums[n];
    }

}