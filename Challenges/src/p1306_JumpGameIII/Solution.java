package p1306_JumpGameIII;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/19 12:59
 */
class Solution {

    public boolean canReach(int[] arr, int start) {
        return dfs(start, arr);
    }

    public boolean dfs(int index, int[] arr) {
        if (index < 0 || index >= arr.length || arr[index] < 0) {
            return false;
        }
        if (arr[index] == 0) {
            return true;
        }
        int temp = arr[index];
        arr[index] = -1;
        return dfs(index - temp, arr) || dfs(index + temp, arr);
    }
}
