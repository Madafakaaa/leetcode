package p769_MaxChunksToMakeSorted;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/23 21:18
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int start = 0;
        boolean[] seen = new boolean[arr.length];
        outLoop:
        for (int i = 0; i < arr.length; i++) {
            seen[arr[i]] = true;
            for (int j = start; j <= i; j++) {
                if (!seen[j]) {
                    continue outLoop;
                }
            }
            res++;
            start = i + 1;
        }
        return res;
    }
}
