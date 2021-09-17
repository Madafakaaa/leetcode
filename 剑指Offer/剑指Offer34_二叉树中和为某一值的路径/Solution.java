package 剑指Offer.剑指Offer34_二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/17 0:48
 */
class Solution {

    List<List<Integer>> res;
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        this.target = target;
        dfs(root, new ArrayList<>(), root.val);
        return res;
    }


    public void dfs(TreeNode node, List<Integer> list, int sum) {
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == target) {
                res.add(new ArrayList<>(list));
            }
        }
        if (node.right != null) {
            dfs(node.right, list, sum + node.right.val);
        }
        if (node.left != null) {
            dfs(node.left, list, sum + node.left.val);
        }
        list.remove(list.size() - 1);
    }

}




















