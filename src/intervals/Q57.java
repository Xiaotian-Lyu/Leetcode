package intervals;

import java.util.ArrayList;
import java.util.List;

public class Q57 {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            //new start/end
            int newStart = newInterval[0], newEnd = newInterval[1];
            List<int[]> list = new ArrayList<>();
            int index = 0;

            //traversal intervals
            //part1:before not overlap => end < newstart
            while(index < intervals.length && intervals[index][1] < newStart){
                list.add(intervals[index]);
                index++;
            }

            //part2:overlap => start <= newend
            while(index < intervals.length && intervals[index][0] <= newEnd){
                //update newend/newstart
                newStart = Math.min(intervals[index][0], newStart);
                newEnd = Math.max(intervals[index][1], newEnd);
                index++;
            }
            //put new start/end into list
            list.add(new int[]{newStart,newEnd});

            //part3:after not overlap => start > newend
            while(index < intervals.length){
                list.add(intervals[index]);
                index++;
            }

            //return result
            int[][] result = new int[list.size()][2];
            for(int i = 0; i < list.size(); i++){
                result[i] = list.get(i);
            }

            return result;

        }
    }
}
