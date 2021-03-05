package p543_DiameterOfBinaryTree;

class Solution {

    public int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateMaxDepth(root);
        return res;
    }

    public int calculateMaxDepth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = calculateMaxDepth(node.left);
        int rightDepth = calculateMaxDepth(node.right);
        res = Math.max(res, leftDepth + rightDepth);
        return Math.max(leftDepth + 1, rightDepth + 1);
    }

}
