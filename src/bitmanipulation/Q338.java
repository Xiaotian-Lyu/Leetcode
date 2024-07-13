package bitmanipulation;

public class Q338 {
    class Solution {
        public int[] countBits(int n) {
            //可以不用判断n = 0, 因为初始化的时候 新建的int[]数组本来就是[0]
            //不能这样初始化：因为 当n =0的时候 new int[1],这个时候res[1] = 1;会超出边界
            //int[] res = new int[n + 1];
            //res[0] = 0;
            //res[1] = 1;

            int[] dp = new int[n + 1];
            if (n == 0) return dp;

            //initial base case
            dp[1] = 1;
            for(int i = 1; i <= n ; i++){
                //even number
                if(i % 2 == 0) dp[i] = dp[i/2];
                else dp[i] = dp[i - 1] + 1;
                //odd number
            }

            return dp;
        }
    }
}
