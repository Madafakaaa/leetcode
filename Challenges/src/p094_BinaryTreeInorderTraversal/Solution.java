package p094_BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * <p>
 * Example 2:
 * Input: root = []
 * Output: []
 * <p>
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorder(new ArrayList<>(), root);
    }

    public List<Integer> inorder(List<Integer> list, TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            if (root.left != null) {
                res.addAll(inorder(list, root.left));
            }
            res.add(root.val);
            if (root.right != null) {
                res.addAll(inorder(list, root.right));
            }
        }
        return res;
    }
}