package p426_ConvertBinarySearchTreeToSortedDoublyLinkedList;


/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/17 14:48
 */
class Solution {

    Node dummy;
    Node temp;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dummy = new Node();
        temp = dummy;
        inorder(root);
        temp.right = dummy.right;
        dummy.right.left = temp;
        return dummy.right;
    }

    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        temp.right = node;
        node.left = temp;
        temp = node;
        inorder(node.right);
    }
}
