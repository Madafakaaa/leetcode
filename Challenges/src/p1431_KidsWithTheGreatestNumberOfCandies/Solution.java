package p1431_KidsWithTheGreatestNumberOfCandies;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/10 9:39
 */
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int c : candies) max = Math.max(c, max);
        ArrayList<Boolean> res = new ArrayList<>(candies.length);
        for (int i = 0; i < candies.length; i++) res.add(candies[i] + extraCandies >= max);
        return res;
    }
}
