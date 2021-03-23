package MovingAverageFromDataStream;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {

    Queue<Integer> queue;
    int size;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() >= size) {
            queue.poll();
        }
        queue.add(val);

        double res = 0;
        for (Integer i : queue) {
            res += i;
        }
        return res / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */