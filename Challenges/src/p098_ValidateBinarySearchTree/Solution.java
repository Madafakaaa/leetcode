package p098_ValidateBinarySearchTree;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 * <p>
 * Example 2:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return root == null || (root.left == null && root.right == null) || validSubBST(root.left, null, null);
    }

    public boolean validSubBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val < min) {
            return false;
        }
        if (max != null && root.val > max) {
            return false;
        }
        return validSubBST(root.left, min, root.val) || validSubBST(root.right, root.val, max);
    }
}