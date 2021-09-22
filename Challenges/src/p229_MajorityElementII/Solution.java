package p229_MajorityElementII;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/20 10:50
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = Integer.MAX_VALUE, candidate2 = Integer.MAX_VALUE;
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>(2);
        if (count1 > nums.length / 3) {
            res.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            res.add(candidate2);
        }
        return res;
    }
}


























