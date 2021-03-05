package p287_FindTheDuplicateNumber;

import java.util.HashSet;

class Solution {

    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) return n;
            set.add(n);
        }
        return -1;
    }

}