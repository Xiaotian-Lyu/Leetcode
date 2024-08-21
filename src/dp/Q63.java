package dp;

public class Q63 {
    class Solution2 {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];

            //initial
            //if-else 的顺序不应调换。当前的顺序是正确的，因为它首先检查了障碍物，并确保一旦遇到障碍物，后续的值不会被错误初始化。
            //不是障碍物就初始化！！！
            /** if else 可以交换位置
             for(int i = 0; i < m; i++){
             if(obstacleGrid[i][0] == 0){
             dp[i][0] = 1;
             //这里属于遇到了一个障碍物后后面都是0，后面的0是默认值
             }else{
             //在这之前都没有 = 1 的情况
             //这个if条件就是判断了前面没有0的情况的赋值
             dp[i][0] = 0;
             break;
             }
             }
             */

            for(int i = 0; i < m; i++){
                if(obstacleGrid[i][0] == 1){
                    dp[i][0] = 0;
                    break;
                    //这里属于遇到了一个障碍物后后面都是0，后面的0是默认值
                }else{
                    //在这之前都没有 = 1 的情况
                    //这个if条件就是判断了前面没有0的情况的赋值
                    dp[i][0] = 1;
                }
            }

            for(int j = 0; j < n; j++){
                if(obstacleGrid[0][j]  == 1){
                    dp[0][j] = 0;
                    break;//这里属于遇到了一个障碍物后后面都是0，后面的0是默认值
                }else{
                    //在这之前都没有 = 1 的情况
                    dp[0][j] = 1;//这个if条件就是判断了前面没有0的情况的赋值
                }
            }

            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    //这里要检查一下目的地是否有障碍物
                    if(obstacleGrid[i][j] == 1){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }

            return dp[m-1][n-1];
        }
    }
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
