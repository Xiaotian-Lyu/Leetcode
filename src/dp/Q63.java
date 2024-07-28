package dp;

public class Q63 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];

            //initial the base case - first row and column
            for(int i = 0; i < m; i++){
                if(obstacleGrid[i][0] == 1){
                    dp[i][0] = 0;//cannot reach to follw next
                    break;
                }else{
                    dp[i][0] = 1;//这里是1 不是 i，代表的路径的数量
                }
            }

            for(int j = 0; j < n; j++){
                if(obstacleGrid[0][j] == 1){
                    dp[0][j] = 0;//cannot reach to follw next
                    break;
                }else{
                    dp[0][j] = 1;//这里是1 不是 i，代表的路径的数量
                }
            }

            //fill the dp array
            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    if(obstacleGrid[i][j] == 1){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }

            return dp[m - 1][n - 1];
        }
    }
}
