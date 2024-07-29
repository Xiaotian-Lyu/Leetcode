package dp;

public class Q221 {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] dp = new int[m][n];
            int maxLength = 0;

            //fill the dp array
            for(int i = 0; i < m ;i++){
                for(int j = 0; j < n; j++){
                    if(matrix[i][j] == '1'){//can make square  注意是char[][] matrix
                        if(i == 0 || j == 0) dp[i][j] = 1;//initialize
                        else{
                            dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                        }
                        maxLength = Math.max(maxLength , dp[i][j]);//这一行要写在外面
                    }
                }
            }

            return maxLength * maxLength;

        }
    }
}
