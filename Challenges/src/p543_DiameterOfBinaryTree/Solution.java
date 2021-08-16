package p543_DiameterOfBinaryTree;

class Solution {

    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        this.res = 0;
        process(root);
        return res;
    }

    public int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = process(root.left);
        int right = process(root.right);
        res = Math.max(left + right + 1, res);
        return Math.max(left, right) + 1;
    }
}
