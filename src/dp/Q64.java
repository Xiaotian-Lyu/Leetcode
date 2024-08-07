package dp;

public class Q64 {
    class Solution {
        public int minPathSum(int[][] grid) {
            //initialize the dp
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n]; //错误int[] dp = new int[m][n];

            //base case
            dp[0][0] = grid[0][0];

            //row and column
            for(int i = 1; i < m; i++){
                dp[i][0] += dp[i - 1][0] + grid[i][0];
            }

            for(int j = 1; j < n; j++){
                dp[0][j] += dp[0][j - 1] + grid[0][j];
            }

            //update the dp
            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    dp[i][j] = Math.min(dp[i - 1][j] , dp[i][j - 1]) + grid[i][j];
                }
            }

            return dp[m -1][n -1];

        }
    }
}
