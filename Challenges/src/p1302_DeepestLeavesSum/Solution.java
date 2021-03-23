package p1302_DeepestLeavesSum;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/20 15:53
 * <p>
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 */
class Solution {

    int res = 0;
    int maxDepth = 0;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        process(root, 0);
        return res;
    }

    public void process(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                res = root.val;
            } else if (depth == maxDepth) res += root.val;
        }
        if (root.left != null) process(root.left, depth + 1);
        if (root.right != null) process(root.right, depth + 1);
    }
}