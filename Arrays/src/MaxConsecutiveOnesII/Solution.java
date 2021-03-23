package MaxConsecutiveOnesII;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, flip = 1, result = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0)
                flip--;

            while (flip < 0 && left < right) {
                if (nums[left] == 0)
                    flip++;

                left++;
                result = Math.max(result, right - left + 1);
            }

            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
