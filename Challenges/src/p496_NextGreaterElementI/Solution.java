package p496_NextGreaterElementI;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/19 17:09
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.add(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
