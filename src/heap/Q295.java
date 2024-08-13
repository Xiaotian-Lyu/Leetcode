package heap;

import java.util.PriorityQueue;

public class Q295 {
    class MedianFinder2 {
        private PriorityQueue<Integer> maxHeap; // 保存较小的一半
        private PriorityQueue<Integer> minHeap; // 保存较大的一半

        public MedianFinder2() {
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            //add to the minHeap - 先加到minheap 就说明minheap 奇数多一个数字 - 保证minheap 的size 比较大
            //如果是先加到maxheap 就说明maxheap 奇数多一个数字 - 保证maxheap 的size 比较大
            minHeap.add(num);
            maxHeap.add(minHeap.poll());

            if(maxHeap.size() > minHeap.size()){
                minHeap.add(maxHeap.poll());
            }
        }

        public double findMedian() {
            //even
            if(maxHeap.size() == minHeap.size()){
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }else{
                //odd
                return minHeap.peek();
            }

        }
    }


    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
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
