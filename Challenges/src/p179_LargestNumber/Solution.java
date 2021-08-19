package p179_LargestNumber;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * <p>
 * Example 1:
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * Example 3:
 * Input: nums = [1]
 * Output: "1"
 * Example 4:
 * Input: nums = [10]
 * Output: "10"
 */
class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<String> numStrs = new ArrayList<>(nums.length);
        for (Integer num : nums) {
            numStrs.add(num.toString());
        }
        Collections.sort(numStrs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        StringBuilder sb = new StringBuilder();
        for (String numStr : numStrs) {
            sb.append(numStr);
        }
        String res = sb.toString();
        while (!res.isEmpty() && res.charAt(0) == '0') {
            res = res.substring(1);
        }
        if (res.isEmpty()) {
            res = "0";
        }
        return res;
    }
}

