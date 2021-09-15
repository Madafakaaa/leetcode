package 剑指Offer.剑指Offer27_二叉树的镜像;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 16:06
 */
class Solution {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.right);
        TreeNode right = mirrorTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }

}
