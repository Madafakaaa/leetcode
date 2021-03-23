package SerializeAndDeserializeBinaryTree;

public class Codec {

    public static final char NULLSTRc = (char) 2001;
    int counter = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        dfsSer(root, sb);
        return sb.toString();
    }

    private void dfsSer(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULLSTRc);
            return;
        }

        sb.append((char) (node.val + 1000));
        dfsSer(node.left, sb);
        dfsSer(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        counter = 0;
        if (data == null) return null;
        return dfsDeser(data);
    }

    private TreeNode dfsDeser(String s) {
        if (s.charAt(counter) == 2001) {
            counter++;
            return null;
        }

        TreeNode tn = new TreeNode(s.charAt(counter) - 1000);
        counter++;
        tn.left = dfsDeser(s);
        tn.right = dfsDeser(s);

        return tn;
    }
}