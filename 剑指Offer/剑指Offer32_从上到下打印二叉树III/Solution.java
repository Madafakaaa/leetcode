package 剑指Offer.剑指Offer32_从上到下打印二叉树III;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/17 0:35
 */
class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        // dfs
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode node, Integer depth) {
        if (node == null) {
            return;
        }
        if (depth >= res.size()) {
            res.add(new ArrayList<>());
        }
        if (depth % 2 == 1) {
            res.get(depth).add(0, node.val);
        } else {
            res.get(depth).add(node.val);
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
























