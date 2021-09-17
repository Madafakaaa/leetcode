package 剑指Offer.剑指Offer41_数据流中的中位数;

import java.util.PriorityQueue;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 0:20
 */
class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty()){
            maxHeap.add(num);
        }else if(num>maxHeap.peek()){
            minHeap.add(num);
        }else{
            maxHeap.add(num);
        }
        balance();
    }

    public void balance() {
        while (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
        while (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() + maxHeap.size() == 0) {
            return 0d;
        }
        if (minHeap.size() == maxHeap.size()) {
            return ((double) (minHeap.peek()) + (double) (maxHeap.peek())) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}


























