package p099_RecoverBinarySearchTree;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/13 17:43
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.val < root.left.val) {
                int temp = root.val;
                root.val = root.left.val;
                root.left.val = temp;
                return;
            }
        }
        if (root.right != null) {
            if (root.val > root.right.val) {
                int temp = root.val;
                root.val = root.right.val;
                root.right.val = temp;
                return;
            }
        }
        recoverTree(root.left);
        recoverTree(root.right);
    }
}
