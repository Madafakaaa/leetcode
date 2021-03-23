package FindAllNumbersDisappeared;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) {
            set.add(i);
        }
        for (int n : nums) {
            set.remove(n);
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        return list;
    }
}
