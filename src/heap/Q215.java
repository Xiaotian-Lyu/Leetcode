package heap;

import java.util.PriorityQueue;

public class Q215 {
    class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            // O(log n)，总体时间复杂度为 O(n + k log n)。对于大规模数据和较大的 `k`，效率可能不高。

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
            for(int i : nums){
                maxHeap.add(i);
            }

            int result = 0;

            for(int i = 0; i < k; i++){
                int poll = maxHeap.poll();
                result = poll;
            }

            return result;
        }
    }
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
