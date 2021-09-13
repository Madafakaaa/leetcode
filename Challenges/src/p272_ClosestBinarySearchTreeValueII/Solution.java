package p272_ClosestBinarySearchTreeValueII;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/13 20:44
 */
class Solution {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        inorder(root, target, k, list);
        return list;

    }

    public void inorder(TreeNode root, double target, int k, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, target, k, list);
        list.add(root.val);
        if (list.size() == k) {
            if (Math.abs(target - root.val) < Math.abs(target - list.peekFirst())) {
                list.removeFirst();
            } else {
                return;
            }
        }
        inorder(root.right, target, k, list);
    }

}
