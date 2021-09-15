package p297_SerializeAndDeserializeBinaryTree;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * <p>
 * Example 2:
 * Input: root = []
 * Output: []
 * <p>
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 * <p>
 * Example 4:
 * Input: root = [1,2]
 * Output: [1,2]
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                sb.append('#');
            } else {
                queue.add(temp.left);
                queue.add(temp.right);
                sb.append(temp.val);
            }
            sb.append(',');
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        String[] strs = data.split(",");
        for (String str : strs) {
            if (str.equals("#")) {
                nodes.add(null);
            } else {
                nodes.add(new TreeNode(Integer.parseInt(str)));
            }
        }
        TreeNode res = nodes.poll();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(res);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                continue;
            }
            TreeNode left = nodes.poll();
            TreeNode right = nodes.poll();
            temp.left = left;
            temp.right = right;
            queue.add(left);
            queue.add(right);
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
