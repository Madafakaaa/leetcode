package p111_MinimumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/10 23:51
 */

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        Integer size;
        TreeNode temp;
        Integer i;
        while (!queue.isEmpty()) {
            // poll all node on this level
            res++;
            size = queue.size();
            for (i = 0; i < size; i++) {
                temp = queue.poll();
                if (temp.right == null && temp.left == null) {
                    queue = null;
                    return res;
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
            }
        }
        queue = null;
        return res;
    }
}

