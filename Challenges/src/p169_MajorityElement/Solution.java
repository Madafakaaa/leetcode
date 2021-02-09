package p169_MajorityElement;

import java.util.TreeMap;

class Solution {

    public int majorityElement(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int n : nums) map.put(n, map.getOrDefault(n,0)+1);
        for(Integer key : map.keySet()){
            if(map.get(key)>nums.length/2) return key;
        }
        return -1;
    }

}