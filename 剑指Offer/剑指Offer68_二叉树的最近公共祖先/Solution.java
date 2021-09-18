package 剑指Offer.剑指Offer68_二叉树的最近公共祖先;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 14:43
 */
class Solution {
    TreeNode res;
    TreeNode p;
    TreeNode q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        search(root);
        return res;
    }

    public Integer search(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int temp = search(node.left) + search(node.right);
        if (node == p || node == q) {
            temp++;
        }
        if (temp == 2) {
            res = node;
            return -1;
        }
        return temp;
    }

}
