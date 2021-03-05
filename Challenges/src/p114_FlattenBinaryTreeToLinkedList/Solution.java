package p114_FlattenBinaryTreeToLinkedList;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public void flatten(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        pushIntoQueue(queue, root);
        TreeNode temp = queue.poll();
        while (!queue.isEmpty()) {
            TreeNode next = queue.poll();
            temp.right = next;
            temp = next;
        }
    }

    public void pushIntoQueue(Queue<TreeNode> queue, TreeNode node) {
        if (node == null) return;
        queue.offer(node);
        pushIntoQueue(queue, node.left);
        pushIntoQueue(queue, node.right);
        node.left = null;
        node.right = null;
    }

}