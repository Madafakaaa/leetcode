package 剑指Offer.剑指Offer59_队列的最大值;

import java.util.LinkedList;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 15:12
 */
class MaxQueue {

    LinkedList<Integer> queue;
    LinkedList<Integer> maxQueue;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        return maxQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.addLast(value);
        while (!maxQueue.isEmpty() && value >= maxQueue.peekLast()) {
            maxQueue.removeLast();
        }
        maxQueue.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int res = queue.pollFirst();
        if (res == maxQueue.peekFirst()) {
            maxQueue.pollFirst();
        }
        return res;
    }
}
