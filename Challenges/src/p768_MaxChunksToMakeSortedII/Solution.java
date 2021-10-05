package p768_MaxChunksToMakeSortedII;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/4 23:58
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int top = 0;
        for (int a : arr) {
            int max = a;
            while (top > 0 && arr[top - 1] > a) {
                max = Math.max(max, arr[--top]);
            }
            arr[top++] = max;
        }
        return top;
    }
}
