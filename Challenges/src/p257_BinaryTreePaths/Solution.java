package p257_BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/13 20:15
 */
class Solution {

    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        backtrack(root, new StringBuilder());
        return res;
    }

    public void backtrack(TreeNode node, StringBuilder sb) {
        String temp = node.val + "->";
        sb.append(temp);
        if (node.left == null && node.right == null) {
            String newStr = sb.toString().substring(0, sb.length() - 2);
            res.add(newStr);
        } else {
            if (node.left != null) {
                backtrack(node.left, sb);
            }
            if (node.right != null) {
                backtrack(node.right, sb);
            }
        }
        sb.delete(sb.length() - temp.length(), sb.length());
    }

}
