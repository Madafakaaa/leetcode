package p113_PathSumII;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    List<List<Integer>> res;
    Integer targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        this.targetSum = targetSum;
        if (root == null) {
            return res;
        }
        dfs(root, 0, new ArrayList<Integer>());
        return res;
    }

    public void dfs(TreeNode node, int prevTotal, List<Integer> list) {
        if (node.right == null && node.left == null) {
            if (prevTotal + node.val == targetSum) {
                list.add(node.val);
                res.add(list);
            }
            list = null;
            return;
        }
        if (node.left != null) {
            List<Integer> nextList = new ArrayList<>();
            nextList.addAll(list);
            nextList.add(node.val);
            dfs(node.left, prevTotal + node.val, nextList);
        }
        if (node.right != null) {
            List<Integer> nextList = new ArrayList<>();
            nextList.addAll(list);
            nextList.add(node.val);
            dfs(node.right, prevTotal + node.val, nextList);
        }
        list = null;
        return;
    }

}
