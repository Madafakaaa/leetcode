package p235_LowestCommonAncestorOfABinarySearchTree;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/13 15:16
 */
class Solution {

    TreeNode res;
    TreeNode p;
    TreeNode q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int count = dfs(node.left) + dfs(node.right);
        if (node == p || node == q) {
            count++;
        }
        if (res == null && count == 2) {
            res = node;
        }
        return count;
    }
}
