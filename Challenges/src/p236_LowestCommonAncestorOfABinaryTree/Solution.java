package p236_LowestCommonAncestorOfABinaryTree;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * <p>
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * Example 3:
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 */
class Solution {

    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        process(root, p, q);
        return res;
    }

    public int process(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int count = process(root.left, p, q) + process(root.right, p, q);
        if (root == p || root == q) {
            count++;
        }
        if (count > 1) {
            this.res = root;
        }
        return count > 0 ? 1 : 0;
    }
}