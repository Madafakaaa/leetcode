package p226_InvertBinaryTree;

class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.left = invertTree(rightNode);
        root.right = invertTree(leftNode);
        return root;
    }

}

