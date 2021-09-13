package p110_BalancedBinaryTree;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/10 23:44
 */
class Solution {

    boolean res;

    public boolean isBalanced(TreeNode root) {
        res = true;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (!res) {
            return 0;
        }
        if (root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            res = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
