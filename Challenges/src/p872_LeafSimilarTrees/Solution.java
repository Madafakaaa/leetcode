package p872_LeafSimilarTrees;

import java.util.ArrayList;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/19 2:40
 */
class Solution {

    ArrayList<Integer> leaves1;
    ArrayList<Integer> leaves2;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        leaves1 = new ArrayList<Integer>();
        leaves2 = new ArrayList<Integer>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        if (leaves1.size() != leaves2.size()) {
            return false;
        }
        for (int i = 0; i < leaves1.size(); i++) {
            if (!leaves1.get(i).equals(leaves2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void dfs(TreeNode node, ArrayList<Integer> leaves) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }
        if (node.left != null) {
            dfs(node.left, leaves);
        }
        if (node.right != null) {
            dfs(node.right, leaves);
        }
    }
}
