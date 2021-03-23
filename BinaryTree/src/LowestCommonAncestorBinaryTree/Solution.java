package LowestCommonAncestorBinaryTree;

class Solution {

    public int maxDepth = -1;
    public TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        go(root, p.val, q.val, 0);
        return res;
    }

    public void go(TreeNode root, int p, int q, int depth) {
        if (root != null && checkAncester(root, p) && checkAncester(root, q) && depth > maxDepth) {
            res = root;
            maxDepth = depth;
            go(root.left, p, q, depth + 1);
            go(root.right, p, q, depth + 1);
        }
    }

    public boolean checkAncester(TreeNode root, int q) {
        if (root == null) {
            return false;
        } else {
            return checkAncester(root.left, q) || checkAncester(root.right, q) || root.val == q;
        }
    }

}