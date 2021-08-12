package p114_FlattenBinaryTreeToLinkedList;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * <p>
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * <p>
 * Example 1:
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * Example 2:
 * Input: root = []
 * Output: []
 * <p>
 * Example 3:
 * Input: root = [0]
 * Output: [0]
 */
class Solution {

    Queue<TreeNode> queue;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        this.queue = new LinkedList<>();
        pushIntoQueue(root);
        TreeNode dummy = new TreeNode(0, null, null);
        TreeNode temp = dummy;
        while (!this.queue.isEmpty()) {
            TreeNode polled = queue.poll();
            polled.left = null;
            polled.right = null;
            temp.right = polled;
            temp = temp.right;
        }
        root = dummy.right;
    }

    public void pushIntoQueue(TreeNode node) {
        if (node == null) {
            return;
        }
        queue.add(node);
        pushIntoQueue(node.left);
        pushIntoQueue(node.right);
    }

}