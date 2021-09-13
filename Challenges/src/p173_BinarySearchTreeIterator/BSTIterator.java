package p173_BinarySearchTreeIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/12 0:41
 */
class BSTIterator {

    int index;
    List<TreeNode> nodes;

    public BSTIterator(TreeNode root) {
        nodes = new ArrayList<>();
        index = 0;
        inorder(root);
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        nodes.add(node);
        inorder(node.right);
    }

    public int next() {
        int res = nodes.get(index).val;
        index++;
        return res;
    }

    public boolean hasNext() {
        return index >= nodes.size();
    }

}

/**
 * class BSTIterator {
 * Stack<TreeNode> stack;
 * TreeNode cur;
 * public BSTIterator(TreeNode root) {
 * stack = new Stack<>();
 * cur = root;
 * }
 * <p>
 * public boolean hasNext() {
 * return cur != null || !stack.isEmpty();
 * }
 * <p>
 * public int next() {
 * while (!stack.isEmpty() || cur != null) {
 * while (cur != null) {
 * stack.add(cur);
 * cur = cur.left;
 * }
 * cur = stack.pop();
 * int val = cur.val;
 * cur = cur.right;
 * return val;
 * }
 * return -1;
 * }
 * }
 */
