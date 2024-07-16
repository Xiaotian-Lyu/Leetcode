package arraryandstring;

import java.util.ArrayList;
import java.util.List;

public class Q54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            //get the border of the matrix
            int up = 0, left =0;
            int down = matrix.length - 1, right = matrix[0].length - 1;

            List<Integer> result = new ArrayList<>();

            //traversal up -> right -> down -> left
            while(up <= down && left <= right){
                for(int i = left; i <= right; i++){
                    result.add(matrix[up][i]);
                }
                up++;
                for(int i = up; i <= down; i++){
                    result.add(matrix[i][right]); //错误写法：result.add(matrix[right][i]);
                }
                right--;

                //需要if 判断 有可能一边先结束
                if(up <= down){
                    for(int i = right; i >= left; i--){
                        result.add(matrix[down][i]);
                    }
                    down--;
                }
                if(left <= right){
                    for(int i = down; i >= up; i--){
                        result.add(matrix[i][left]);
                    }
                    left++;
                }

            }

            return result;

        }
    }
}
