package dp;

public class Q72 {
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();

            //dp -> int
            int[][] dp = new int[m + 1][n + 1];//index

            //base case
            for(int i = 0; i <= m ; i++){
                dp[i][0] = i;
            }

            for(int j = 0; j <= n ; j++){
                dp[0][j] = j;
            }


            //dp
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n ; j++){
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.min(Math.min(
                                        dp[i-1][j-1] + 1,
                                        dp[i-1][j] + 1),//Math.min只能比较两个数
                                dp[i][j-1] + 1

                        );

                    }

                }
            }

            return dp[m][n];

        }
    }
}
