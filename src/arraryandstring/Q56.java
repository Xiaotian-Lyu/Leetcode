package arraryandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q56 {
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
