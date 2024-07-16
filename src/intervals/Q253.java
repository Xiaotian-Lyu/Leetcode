package intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q253 {
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            //sort the start time
            Arrays.sort(intervals, (a, b) -> a[0]-b[0]);

            //minHeap => track the end time
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            minHeap.add(intervals[0][1]);

            //traversal meeting: if new start time >= end time / poll the old end time
            for(int i = 1; i < intervals.length; i++){
                if(intervals[i][0] >= minHeap.peek()){
                    minHeap.poll();
                }
                //add to the minHeap
                minHeap.add(intervals[i][1]);

            }

            //return the minHeap.size()
            return minHeap.size();

        }
    }
}
