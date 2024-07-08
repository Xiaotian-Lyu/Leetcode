package heap;

import java.util.PriorityQueue;

public class Q973 {
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                    //错误写法：(a,b) -> b[0]*b[0]+b[1]*b[1] - a[0]*a[0]+a[1]*a[1]
                    (a,b) -> (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1])
            );

            // for(int i = 0 ; i < k ; i++){
            //     maxHeap.add(int[i])
            // } 错误 要把所有的 都加加进去

            for(int[] point : points){
                maxHeap.add(point);
                if(maxHeap.size() > k){
                    maxHeap.poll(); //poll 出来的永远是最大的
                }
            }

            int[][] result = new int[k][2];
            for(int i = 0; i < k ; i++){
                result[i] = maxHeap.poll();
            }

            return result;
        }
    }

}
