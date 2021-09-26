package p540_SingleElementInASortedArray;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/23 21:26
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
