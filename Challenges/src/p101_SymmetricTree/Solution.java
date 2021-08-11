package p101_SymmetricTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * <p>
 * Example 1:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * <p>
 * Example 2:
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        List<Integer> inorder = inorder(new ArrayList<>(), root);
        List<Integer> reversedInorder = reversedInorder(new ArrayList<>(), root);
        return inorder.equals(reversedInorder);
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

    public List<Integer> reversedInorder(List<Integer> list, TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            if (root.right != null) {
                res.addAll(inorder(list, root.right));
            }
            res.add(root.val);
            if (root.left != null) {
                res.addAll(inorder(list, root.left));
            }
        }
        return res;
    }
}
