package 剑指Offer.剑指Offer50_第一个只出现一次的字符;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 20:18
 */
class Solution {
    public char firstUniqChar(String s) {
        Queue<Character> queue = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                queue.remove(c);
            } else {
                set.add(c);
                queue.add(c);
            }
        }
        return queue.isEmpty() ? ' ' : queue.poll();
    }
}
