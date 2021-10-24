package p404_SumOfLeftLeaves;

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

    int res;

    public int sumOfLeftLeaves(TreeNode root) {
        res = 0;
        dfs(root, false);
        return res;
    }

    public void dfs(TreeNode node, boolean isLeft) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (isLeft) {
                res += node.val;
            }
            return;
        }
        dfs(node.left, true);
        dfs(node.right, false);
    }
}