package p199_BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * <p>
 * Example 2:
 * Input: root = [1,null,3]
 * Output: [1,3]
 * <p>
 * Example 3:
 * Input: root = []
 * Output: []
 */
class Solution {

    ArrayList<Integer> list;

    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<>();
        levelOrder(root, 0);
        return list;
    }

    public void levelOrder(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (list.size() > depth) {
            list.set(depth, root.val);
        } else {
            list.add(root.val);
        }
        levelOrder(root.left, depth + 1);
        levelOrder(root.right, depth + 1);
    }

}