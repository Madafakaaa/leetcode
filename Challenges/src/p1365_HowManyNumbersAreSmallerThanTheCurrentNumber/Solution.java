package p1365_HowManyNumbersAreSmallerThanTheCurrentNumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/12 9:33
 */
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        List<Integer> sortedList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(sortedList);
        HashMap<Integer, Integer> order = new HashMap<>(nums.length);
        for (Object i : sortedList) {
            Integer num = (Integer) i;
            if (!order.containsKey(num)) {
                order.put(num, sortedList.indexOf(i));
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = order.getOrDefault(nums[i], 0);
        }
        return res;
    }
}