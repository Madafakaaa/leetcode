package p428_SerializeAndDeserializeNaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/14 17:04
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + ",#,");
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (Node child : temp.children) {
                sb.append(child.val + ",");
                queue.add(child);
            }
            sb.append("#,");
        }
        return sb.toString().substring(0,sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        Queue<Node> nodes = new LinkedList<>();
        String[] strs = data.split(",");
        for (String str : strs) {
            if (str.equals("#")) {
                nodes.add(null);
            } else {
                nodes.add(new Node(Integer.parseInt(str), new ArrayList<>()));
            }
        }
        Node res = nodes.poll();
        nodes.poll();
        Queue<Node> queue = new LinkedList<>();
        queue.add(res);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            while (nodes.peek() != null) {
                Node child = nodes.poll();
                temp.children.add(child);
                queue.add(child);
            }
            nodes.poll();
        }
        return res;
    }

}





















