package p117_PopulatingNextRightPointersInEachNodeII;

import java.util.ArrayList;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/3 11:37
 */
class Solution {

    ArrayList<Node> layerRight;

    public Node connect(Node root) {
        layerRight = new ArrayList<>();
        dfs(root, 0);
        return root;
    }

    public void dfs(Node node, int depth) {
        if (node == null) {
            return;
        }
        if (depth >= layerRight.size()) {
            layerRight.add(node);
        } else {
            Node prevNode = layerRight.get(depth);
            prevNode.next = node;
            layerRight.set(depth, node);
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

}
