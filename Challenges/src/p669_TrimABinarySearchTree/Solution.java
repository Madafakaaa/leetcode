package p669_TrimABinarySearchTree;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/19 16:55
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        root = helper(root, low, high);
        return root;
    }

    public TreeNode helper(TreeNode node, int low, int high) {
        if (node == null) {
            return null;
        }
        if (node.val < low) {
            return helper(node.right, low, high);
        } else if (node.val > high) {
            return helper(node.left, low, high);
        }
        node.left = helper(node.left, low, high);
        node.right = helper(node.right, low, high);
        return node;
    }
}
