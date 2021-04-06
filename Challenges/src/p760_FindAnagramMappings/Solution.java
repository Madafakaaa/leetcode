package p760_FindAnagramMappings;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/4/6 17:05
 * <p>
 * Given two lists A and B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.
 * <p>
 * We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.
 * <p>
 * These lists A and B may contain duplicates. If there are multiple answers, output any of them.
 * <p>
 * For example, given
 * <p>
 * A = [12, 28, 46, 32, 50]
 * B = [50, 12, 32, 46, 28]
 * We should return
 * [1, 4, 3, 2, 0]
 * as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
 * Note:
 * <p>
 * A, B have equal lengths in range [1, 100].
 * A[i], B[i] are integers in range [0, 10^5].
 */
class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        int length = A.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            LinkedList<Integer> indexList = map.getOrDefault(B[i], new LinkedList<>());
            indexList.add(i);
            map.put(B[i], indexList);
        }
        for (int i = 0; i < length; i++) {
            res[i] = map.get(A[i]).pollFirst();
        }
        return res;
    }
}