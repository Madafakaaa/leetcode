package 剑指Offer.剑指Offer54_二叉搜索树的第k大节点;

import java.util.ArrayList;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 14:18
 */
class Solution {

    ArrayList<Integer> res;
    Integer k;

    public int kthLargest(TreeNode root, int k) {
        res = new ArrayList<>();
        this.k = k;
        dfs(root);
        return res.get(k - 1);
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (res.size() >= k) {
            return;
        }
        dfs(node.left);
        res.add(node.val);
        dfs(node.right);
    }
}
