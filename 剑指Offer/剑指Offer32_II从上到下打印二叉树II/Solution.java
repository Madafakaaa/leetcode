package 剑指Offer.剑指Offer32_II从上到下打印二叉树II;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 18:09
 */
class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth >= res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(node.val);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
