package p938_RangeSumOfBST;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/4/6 17:14
 * <p>
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
 * <p>
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val >= low && root.val <= high) {
            res += root.val;
        }
        if (root.left != null) {
            res += rangeSumBST(root.left, low, high);
        }
        if (root.right != null) {
            res += rangeSumBST(root.right, low, high);
        }
        return res;
    }
}
