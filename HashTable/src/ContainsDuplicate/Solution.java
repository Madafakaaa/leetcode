package ContainsDuplicate;

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        if(set.size()<nums.length){
            return true;
        }
        return false;
    }
}
