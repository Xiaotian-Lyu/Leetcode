package heap;

import java.util.PriorityQueue;

public class Q215 {
    class Solution {
        //To find the Kth largest == use minheap
        //== pop the minheap when heap.size > k

        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

            for(int num : nums){
                minHeap.offer(num);
                if(minHeap.size() > k){
                    minHeap.poll();
                }
            }
            return minHeap.peek();
        }

    }
}
