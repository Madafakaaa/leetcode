package p1469_FindAllTheLonelyNodes;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/4/13 9:38
 * <p>
 * In a binary tree, a lonely node is a node that is the only child of its parent node. The root of the tree is not lonely because it does not have a parent node.
 * <p>
 * Given the root of a binary tree, return an array containing the values of all lonely nodes in the tree. Return the list in any order.
 */
class Solution {

    List<Integer> res = new ArrayList<>();

    public List<Integer> getLonelyNodes(TreeNode root) {
        iter(root);
        return res;
    }

    public void iter(TreeNode node) {
        if (node == null) return;
        if (node.left != null && node.right != null) {
            iter(node.left);
            iter(node.right);
            return;
        }
        if (node.left != null) {
            res.add(node.left.val);
            iter(node.left);
        }
        if (node.right != null) {
            res.add(node.right.val);
            iter(node.right);
        }
    }
}