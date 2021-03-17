package p1313_DecompressRunLengthEncodedList;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/17 9:49
 */
class Solution {
    public int[] decompressRLElist(int[] nums) {
        int arrayLen = 0;
        for (int i = 0; i < nums.length; i += 2) {
            arrayLen += nums[i];
        }
        int[] res = new int[arrayLen];
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                res[index] = nums[i + 1];
                index++;
            }
        }
        return res;
    }
}