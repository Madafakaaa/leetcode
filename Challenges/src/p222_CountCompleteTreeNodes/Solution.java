package p222_CountCompleteTreeNodes;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/13 14:48
 */
class Solution {

    int minDepth;

    public int countNodes(TreeNode root) {
        minDepth = 0;
        minDepth(root);
        int res = (int) (Math.pow(2, minDepth) - 1);
        for (int i = res; i > 0; i--) {
            if (findLeaf(root, (int) (Math.pow(2, minDepth - 1)), i)) {
                return res + i;
            }
        }
        return res;
    }

    public void minDepth(TreeNode node) {
        while (node != null) {
            node = node.right;
            minDepth++;
        }
    }

    public boolean findLeaf(TreeNode node, int split, int target) {
        if (node == null) {
            return false;
        }
        if (split == 0) {
            return true;
        }
        if (target > split) {
            return findLeaf(node.right, split / 2, target - split);
        } else {
            return findLeaf(node.left, split / 2, target);
        }
    }

}
