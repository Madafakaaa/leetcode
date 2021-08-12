package p1448_CountGoodNodesInBinaryTree;

/**
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * <p>
 * Return the number of good nodes in the binary tree.
 * <p>
 * Example 1:
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 */
class Solution {

    public int result = 0;

    public int goodNodes(TreeNode root) {
        goodNodes(root, Integer.MIN_VALUE);
        return result;
    }

    public void goodNodes(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val <= max) {
            result++;
            max = Math.max(max, root.val);
        }
        goodNodes(root.left, max);
        goodNodes(root.right, max);
    }
}
