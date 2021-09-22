package p575_DistributeCandies;

import java.util.HashSet;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/19 15:19
 */
class Solution {
    public int distributeCandies(int[] candyType) {
        int halfNum = candyType.length / 2;
        HashSet<Integer> set = new HashSet<>();
        int typeNum = 0;
        for (int candy : candyType) {
            if (!set.contains(candy)) {
                typeNum++;
                set.add(candy);
            }
        }
        if (halfNum >= typeNum) {
            return typeNum;
        }
        return halfNum;
    }
}
