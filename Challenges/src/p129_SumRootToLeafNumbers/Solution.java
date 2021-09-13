package p129_SumRootToLeafNumbers;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/12 0:34
 */
class Solution {

    Integer res;

    public int sumNumbers(TreeNode root) {
        res = 0;
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode node, Integer prevSum) {
        if (node == null) {
            return;
        }
        Integer nextSum = 10 * prevSum + node.val;
        if (node.left == null && node.right == null) {
            res += nextSum;
        }
        dfs(node.left, nextSum);
        dfs(node.right, nextSum);
    }

}
