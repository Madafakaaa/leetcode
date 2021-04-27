package p1213_IntersectionOfThreeSortedArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/4/27 17:14
 * <p>
 * Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order,
 * return a sorted array of only the integers that appeared in all three arrays.
 * <p>
 * Example 1:
 * <p>
 * Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * Output: [1,5]
 * Explanation: Only 1 and 5 appeared in the three arrays.
 * <p>
 * Example 2:
 * <p>
 * Input: arr1 = [197,418,523,876,1356], arr2 = [501,880,1593,1710,1870], arr3 = [521,682,1337,1395,1764]
 * Output: []
 */
class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(arr1.length);
        for (int i1 : arr1) {
            map.put(i1, 1);
        }
        for (int i2 : arr2) {
            map.put(i2, map.getOrDefault(i2, 0));
        }
        for (int i3 : arr3) {
            if (map.getOrDefault(i3, 0) == 2) {
                res.add(i3);
            }
        }
        return res;
    }
}
