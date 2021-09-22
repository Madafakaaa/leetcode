package QuickChallenges.p421_MaximumXOROfTwoNumbersInAnArray;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/22 12:52
 */
class Solution {
    private final TrieNode root = new TrieNode();
    private int res = 0;

    private void insert(int[] bits) {
        TrieNode trieNode, current, next;
        trieNode = current = root;
        int num = 0, bit;
        for (int i = 0; i < 32; i++) {
            bit = bits[i];
            trieNode = trieNode.insert(bit);
            next = current.getNodeByBit(bit ^ 1);
            num <<= 1;
            if (null == next) {
                next = current.getNodeByBit(bit);
            } else {
                num |= 1;
            }
            current = next;
            bits[i] = 0;
        }
        res = Math.max(res, num);
    }

    public int findMaximumXOR(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            int index = bits.length - 1;
            while (num > 0) {
                bits[index--] = 1 & num;
                num >>= 1;
            }
            insert(bits);
        }
        return res;
    }
}

class TrieNode {
    private final TrieNode[] links;

    public TrieNode() {
        links = new TrieNode[2];
    }

    public TrieNode getNodeByBit(int bit) {
        return links[bit];
    }

    public TrieNode insert(int bit) {
        TrieNode trieNode = links[bit];
        if (null == trieNode) {
            trieNode = new TrieNode();
            links[bit] = trieNode;
        }
        return trieNode;
    }
}
