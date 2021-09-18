package 剑指Offer.剑指Offer55_平衡二叉树;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 17:21
 */
class Solution {

    boolean res;

    public boolean isBalanced(TreeNode root) {
        res = true;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (Math.abs(left - right) > 1) {
            res = false;
        }
        return Math.max(left, right) + 1;
    }
}
