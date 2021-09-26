package p701_InsertIntoABinarySearchTree;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/25 18:48
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
