package p103_BinaryTreeZigzagLevelOrderTraversal;

import java.util.*;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/5 9:25
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (Objects.isNull(root)) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp = null;
        int i = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> deque = new LinkedList<>();
            for (int j = 0; j < size; j++) {
                temp = queue.poll();
                if (Objects.nonNull(temp.left)) {
                    queue.add(temp.left);
                }
                if (Objects.nonNull(temp.right)) {
                    queue.add(temp.right);
                }
                deque.add(temp.val);
            }
            if (i % 2 == 0) {
                res.add(deque);
            } else {
                List<Integer> reversed = new ArrayList<>(deque.size());
                while (!deque.isEmpty()) {
                    reversed.add(deque.pollLast());
                }
                res.add(reversed);
            }
            i++;
        }
        return res;
    }
}