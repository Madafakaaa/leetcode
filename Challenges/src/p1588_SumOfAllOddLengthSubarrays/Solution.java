package p1588_SumOfAllOddLengthSubarrays;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/31 9:52
 * <p>
 * Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.
 * <p>
 * A subarray is a contiguous subsequence of the array.
 * <p>
 * Return the sum of all odd-length subarrays of arr.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,4,2,5,3]
 * Output: 58
 * Explanation: The odd-length subarrays of arr and their sums are:
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 */
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for (int i = 1; i <= arr.length; i += 2) {
            for (int j = 0; j < arr.length - i; j++) {
                for (int k = j; k < j + i; k++) {
                    res += arr[k];
                }
            }
        }
        return res;
    }
}
