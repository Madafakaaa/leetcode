package p096_UniqueBinarySearchTrees;

/**
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 * <p>
 * Example 1:
 * Input: n = 3
 * Output: 5
 * <p>
 * Example 2:
 * Input: n = 1
 * Output: 1
 */
class Solution {
    public int numTrees(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; ++j) {
                count[i] += count[j - 1] * count[i - j];
            }
        }
        return count[n];
    }
}