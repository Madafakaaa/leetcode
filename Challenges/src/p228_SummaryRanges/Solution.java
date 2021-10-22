package p228_SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/19 22:55
 */
class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Integer start = null;
        Integer end = null;
        for (int num : nums) {
            if (start == null) {
                start = num;
                end = num;
            } else {
                if (num - 1 != end) {
                    res.add(convert(start, end));
                    start = num;
                    end = num;
                } else {
                    end++;
                }
            }
        }
        return res;
    }

    public String convert(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        } else {
            return start + "->" + end;
        }
    }

}
