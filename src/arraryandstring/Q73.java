package arraryandstring;

public class Q73 {
    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length - 1;//rows
            int n = matrix[0].length - 1;//cols
            boolean firstRow = false;
            boolean firstCol = false;

            //check first row col if contains 0, mark
            for(int i = 0; i <= n; i++){
                if(matrix[0][i] == 0){//行 = 0
                    firstRow = true;
                    break; //找到一行就出循环
                }
            }
            for(int i = 0; i <= m; i++){
                if(matrix[i][0] == 0){//列 = 0
                    firstCol = true;
                    break;//找到一列就出循环
                }
            }

            //traversal the matrix, if contains 0, mark on the first row/col
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(matrix[i][j] == 0){
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }


            //traversal again to change the row/col to 0
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(matrix[i][0] == 0 || matrix[0][j] == 0 ){
                        matrix[i][j] = 0;
                    }
                }
            }

            //change the first row/col to 0
            if(firstRow){
                for(int i = 0; i <= n; i++){
                    matrix[0][i] = 0;
                }
            }
            if(firstCol){
                for(int i = 0; i <= m; i++){
                    matrix[i][0] = 0;
                }
            }


        }
    }
}
