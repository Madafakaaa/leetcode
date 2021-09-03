package p384_ShuffleAnArray;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/3 11:53
 */
class Solution {

    int[] copy;
    Random random;

    public Solution(int[] nums) {
        copy = Arrays.copyOf(nums, nums.length);
        random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return Arrays.copyOf(copy, copy.length);
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        // fisher-yates
        int[] ans = Arrays.copyOf(copy, copy.length);

        for (int i = ans.length - 1; i >= 0; i--) {
            int newIndex = random.nextInt(i + 1);
            int temp = ans[i];
            ans[i] = ans[newIndex];
            ans[newIndex] = temp;
        }
        return ans;
    }
}
