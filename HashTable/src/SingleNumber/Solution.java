package SingleNumber;

import java.util.HashSet;

class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> once = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!once.contains(nums[i])) {
                once.add(nums[i]);
            } else {
                once.remove((Object) nums[i]);
            }
        }
        return once.iterator().next();
    }

    // ??????????????????
    public int singleNumber1(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}