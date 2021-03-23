package CountUnivalueSubtrees;

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

    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        count(root);
        return count;
    }

    public boolean count(TreeNode root) {
        if (root.left == null && root.right == null) {
            count++;
            return true;
        } else if (root.left != null && root.right != null) {
            boolean leftIsUnival = count(root.left);
            boolean rightIsUnival = count(root.right);
            if (leftIsUnival && root.val == root.left.val && rightIsUnival && root.val == root.right.val) {
                count++;
                return true;
            } else {
                return false;
            }
        } else if (root.left != null) {
            boolean leftIsUnival = count(root.left);
            if (leftIsUnival && root.val == root.left.val) {
                count++;
                return true;
            } else {
                return false;
            }
        } else if (root.right != null) {
            boolean rightIsUnival = count(root.right);
            if (rightIsUnival && root.val == root.right.val) {
                count++;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}