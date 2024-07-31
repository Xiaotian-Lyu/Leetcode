package heap;

import java.util.PriorityQueue;

public class Q295 {
    class MedianFinder {
        //two heap
        PriorityQueue<Integer> maxHeap;//keep the half small nums
        PriorityQueue<Integer> minHeap;//keep the half big nums

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((a,b) -> b-a);//keep the half small nums
            minHeap = new PriorityQueue<>();//keep the half big nums
        }

        public void addNum(int num) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            if(maxHeap.size() < minHeap.size()){
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if(maxHeap.size() == minHeap.size()){
                return (maxHeap.peek() + minHeap.peek())  / 2.0;
            }else{
                return maxHeap.peek();
            }

        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
