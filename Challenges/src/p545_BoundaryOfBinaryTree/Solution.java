package p545_BoundaryOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/3 19:18
 */
class Solution {
    List<Integer> res;

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        if (isLeaf(root)) {
            return res;
        }
        // get left boundary
        TreeNode temp = root;
        getLeft(temp.left);
        temp = root;
        getRoots(temp);
        temp = root;
        getRight(temp.right);
        return res;
    }

    public void getLeft(TreeNode node) {
        if (node == null) {
            return;
        }
        if (isLeaf(node)) {
            return;
        }
        res.add(node.val);
        if (node.left != null) {
            getLeft(node.left);
        } else {
            getLeft(node.right);
        }
    }

    public void getRoots(TreeNode node) {
        if (node == null) {
            return;
        }
        if (isLeaf(node)) {
            res.add(node.val);
        } else {
            getRoots(node.left);
            getRoots(node.right);
        }
    }

    public void getRight(TreeNode node) {
        if (node == null) {
            return;
        }
        if (isLeaf(node)) {
            return;
        }
        if (node.right != null) {
            getRight(node.right);
        } else {
            getRight(node.left);
        }
        res.add(node.val);
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
