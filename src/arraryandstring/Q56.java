package arraryandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q56 {
    class Solution2 {
        public int[][] merge(int[][] intervals) {
            // Step 1: Sort intervals by the starting point
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            // Step 2: Initialize a list to store merged intervals
            List<int[]> result = new ArrayList<>();

            // Step 3: Merge intervals
            for (int[] interval : intervals) {
                if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                    // No overlap or first interval
                    result.add(interval);
                } else {
                    // Merge with the last interval in result
                    result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
                }
            }

            // Convert List<int[]> to int[][]
            int[][] merged = new int[result.size()][2];
            for (int i = 0; i < result.size(); i++) {
                merged[i] = result.get(i);
            }

            return merged;
        }
    }
    class Solution {
        public int[][] merge(int[][] intervals) {
            //sort intervlas 错误写法：Arrays.sort(intervals,(a,b) -> (a[0]b[0]));
            Arrays.sort(intervals,(a, b) -> (a[0] - b[0]));
            //a result to add all scope
            List<int[]> result = new ArrayList<>();

            //update the end and start
            //注意这里的start 和 end 是要一直更新的 错误写法 int start = intervals[0][0], end = intervals[0][1];
            for(int i = 0; i < intervals.length; i++){
                int start = intervals[i][0], end = intervals[i][1];
                //错误写法：while(i + 1 < intervals.length && end >= intervals[i + 1][1])
                while(i + 1 < intervals.length && end >= intervals[i + 1][0]){
                    end = Math.max(end, intervals[i + 1][1]);
                    //千万别忘了
                    i++;
                }
                result.add(new int[]{start, end});
            }

            //transfer the result
            int[][] finalResult = new int[result.size()][2];
            for(int i = 0; i < result.size() ; i++){
                finalResult[i] = result.get(i);
            }

            return finalResult;


        }
    }
}
