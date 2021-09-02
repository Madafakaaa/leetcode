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

    // Decodes your encoded data to tree.
    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        solve(root, sb);
        return sb.toString();
    }

    public void solve(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        solve(root.left, sb);
        solve(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return solve2(arr);
    }

    public TreeNode solve2(String[] arr) {
        if (index >= arr.length || arr[index].equals("null")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
        root.left = solve2(arr);
        root.right = solve2(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
