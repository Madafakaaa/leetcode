package 剑指Offer.剑指Offer55_二叉树的深度;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 17:32
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
