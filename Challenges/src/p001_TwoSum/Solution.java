package p001_TwoSum;

import java.util.TreeMap;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


}
