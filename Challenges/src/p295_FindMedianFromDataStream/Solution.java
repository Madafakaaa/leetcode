package p295_FindMedianFromDataStream;

import java.util.ArrayList;

class MedianFinder {

    ArrayList<Integer> list;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        list = new ArrayList<Integer>();
    }

    public void addNum(int num) {
        int left = 0, right = list.size() - 1, mid;
        while (left < right - 1) {
            mid = left + (right - left / 2);
            if (list.get(mid) <= num) {
                left = mid;
            } else {
                right = mid;
            }
        }
        list.add(left, num);
    }

    public double findMedian() {
        if (list.size() % 2 == 1) {
            return list.get(list.size() / 2);
        } else {
            return (double) (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */