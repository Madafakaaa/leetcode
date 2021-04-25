package p1534_CountGoodTriplets;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/4/25 13:29
 */
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        int length = arr.length;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < length; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && (Math.abs(arr[i] - arr[k]) <= c)) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}