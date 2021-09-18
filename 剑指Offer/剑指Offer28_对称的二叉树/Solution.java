package 剑指Offer.剑指Offer28_对称的二叉树;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 17:33
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
