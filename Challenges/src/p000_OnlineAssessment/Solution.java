package p000_OnlineAssessment;

import java.util.PriorityQueue;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/9 9:37
 */
class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        PriorityQueue<Double> heap = new PriorityQueue<Double>((a, b) -> {
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else {
                return 0;
            }
        });
        for (int i = 1; i < stations.length; i++) {
            heap.add((double) (stations[i] - stations[i - 1]));
        }
        for (int i = 0; i < k; i++) {
            double tempMax = heap.poll();
            heap.add(tempMax / 2.0);
            heap.add(tempMax / 2.0);
        }
        return heap.peek();
    }
}
