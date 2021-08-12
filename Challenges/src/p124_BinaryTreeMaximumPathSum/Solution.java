package p124_BinaryTreeMaximumPathSum;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * <p>
 * The path sum of a path is the sum of the node's values in the path.
 * <p>
 * Given the root of a binary tree, return the maximum path sum of any path.
 * <p>
 * Example 1:
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * <p>
 * Example 2:
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 */
class Solution {

    Integer result;

    public int maxPathSum(TreeNode root) {
        this.result = Integer.MIN_VALUE;
        getMaxPathSum(root);
        return this.result;
    }

    public int getMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = getMaxPathSum(root.left);
        int rightMax = getMaxPathSum(root.right);
        int localMax = root.val + Math.max(0, leftMax) + Math.max(0, rightMax);
        this.result = Math.max(localMax, this.result);
        return root.val + Math.max(Math.max(leftMax, rightMax), 0);
    }

}