package PerfectSquares;

class Solution {

    public int numSquares(int n) {
        int[] nums = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.MAX_VALUE;
        }
        int[] sqrs = new int[(int) Math.sqrt(n) + 1]; // +1?
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