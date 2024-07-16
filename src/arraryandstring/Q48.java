package arraryandstring;

public class Q48 {
    class Solution {
        public void rotate(int[][] matrix) {
            //size of the matrix
            int m = matrix.length;

            //filp diagonal
            for(int i = 0; i <= m - 1; i++){
                for(int j = 0; j < i; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            //filp central line
            for(int[] row : matrix){
                int i = 0, j = matrix[0].length - 1;
                while(i < j){
                    int temp = row[i];
                    row[i] = row[j];
                    row[j] = temp;
                    i++;
                    j--;
                }
            }

        }
    }
}
