package p1389_CreateTargetArrayInTheGivenOrder;

import java.util.LinkedList;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/30 16:39
 * <p>
 * Given two arrays of integers nums and index. Your task is to create target array under the following rules:
 * <p>
 * Initially target array is empty.
 * From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
 * Repeat the previous step until there are no elements to read in nums and index.
 * Return the target array.
 * <p>
 * It is guaranteed that the insertion operations will be valid.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * Output: [0,4,1,3,2]
 * Explanation:
 * nums       index     target
 * 0            0        [0]
 * 1            1        [0,1]
 * 2            2        [0,1,2]
 * 3            2        [0,1,3,2]
 * 4            1        [0,4,1,3,2]
 */

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int length = nums.length;
        int i;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (i = 0; i < length; i++) list.add(index[i], nums[i]);
        int[] res = new int[length];
        for (i = 0; i < length; i++) res[i] = list.poll();
        return res;
    }
}
