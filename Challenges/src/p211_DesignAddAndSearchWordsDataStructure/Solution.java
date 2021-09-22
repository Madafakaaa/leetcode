package p211_DesignAddAndSearchWordsDataStructure;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/21 23:23
 */
class WordDictionary {

    TrieNode root = new TrieNode();

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {

    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new TrieNode();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.isWord = true;
    }

    // Way II. Backtracking
    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    public boolean search(char[] word, int index, TrieNode cur) {
        if (index == word.length) {
            return cur.isWord;
        }
        char ch = word[index];
        if (ch == '.') {
            for (TrieNode child : cur.children) {
                if (child != null && search(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            if (cur.children[ch - 'a'] == null) {
                return false;
            }
            return search(word, index + 1, cur.children[ch - 'a']);
        }
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
