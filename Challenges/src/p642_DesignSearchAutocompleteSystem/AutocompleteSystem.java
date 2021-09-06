package p642_DesignSearchAutocompleteSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/6 10:55
 */
class AutocompleteSystem {

    private TrieNode root, type;
    private HashMap<String, Integer> count;
    private StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        type = root;
        count = new HashMap<>();
        sb = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            count.put(sentences[i], times[i]);
            update(sentences[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            type = root;
            String s = sb.toString();
            sb = new StringBuilder();
            count.put(s, count.getOrDefault(s, 0) + 1);
            update(s);
            return new ArrayList<>();
        }
        sb.append(c);
        if (type == null) return new ArrayList<>();
        int index = c == ' ' ? 26 : c - 'a';
        type = type.children[index];
        if (type == null) return new ArrayList<>();
        return new ArrayList<>(type.hotlist);
    }

    private void update(String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) == ' ' ? 26 : s.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
            insert(cur.hotlist, s);
        }

    }

    private void insert(ArrayList<String> hotlist, String s) {
        int i;
        for (i = 0; i < hotlist.size(); i++) {
            if (hotlist.get(i).equals(s)) {
                hotlist.remove(i);
                break;
            }
        }
        for (i = 0; i < hotlist.size(); i++) {
            if (greater(s, hotlist.get(i))) {
                hotlist.add(i, s);
                break;
            }
        }
        if (i == hotlist.size()) hotlist.add(s);
        if (hotlist.size() > 3) hotlist.remove(hotlist.size() - 1);
    }

    private boolean greater(String a, String b) {
        int count_a = count.get(a), count_b = count.get(b);
        if (count_a != count_b) return count_a > count_b;
        int i;
        for (i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) < b.charAt(i)) return true;
            else if (a.charAt(i) > b.charAt(i)) return false;
        }
        return i == a.length();
    }

    class TrieNode {
        private TrieNode[] children;
        private ArrayList<String> hotlist;

        public TrieNode() {
            children = new TrieNode[27];
            hotlist = new ArrayList<>();
        }
    }
}
