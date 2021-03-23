package RemoveDuplicates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

class Solution {

    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        Iterator<Integer> ite = set.iterator();
        int result = 0;
        while (ite.hasNext()) {
            nums[result] = ite.next();
            result++;
        }
        Arrays.sort(nums, 0, result);
        return result;
    }

}