package p295_FindMedianFromDataStream;

import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        if (minHeap.size() != 0) {
            max = minHeap.peek();
        }
        if (maxHeap.size() != 0) {
            min = maxHeap.peek();
        }
        if (num > min) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
        balance();
    }

    private void balance() {
        if (maxHeap.size() < minHeap.size()) {
            int val = minHeap.poll();
            maxHeap.add(val);
        } else if (maxHeap.size() > minHeap.size() + 1 && maxHeap.size() > 1) {
            int val = maxHeap.poll();
            minHeap.add(val);
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        }
        return ((double) maxHeap.peek() + minHeap.peek()) / 2;
    }
}
