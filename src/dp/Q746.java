package dp;

public class Q746 {
    // 方式一：第一步不支付费用
    // 方式一：第一步不支付费用
    class Solution {
        public int minCostClimbingStairs(int[] cost) {

            int n = cost.length;
            //top = n + 1
            int[] dp = new int[n + 1];

            //base case
            dp[0] = 0;
            dp[1] = 0;

            for(int i = 2 ; i <= n; i++){
                //two situation : climb 1 or 2
                dp[i] = Math.min(dp[i - 1] + cost[i - 1],dp[i - 2] + cost[i - 2]);
            }

            return dp[n];
        }
    }
    // 方式2：第一步支付费用
    class Solution2 {
        public int minCostClimbingStairs(int[] cost) {
            //top
            int n = cost.length;
            int[] dp = new int[n];

            //base case
            dp[0] = cost[0];
            dp[1] = cost[1];

            for(int i = 2 ; i < n; i++){
                //two situation : climb 1 or 2
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
            }
            //这里的最后一步是n,则最后一步的体力花费可以不用算
            return Math.min(dp[n - 1], dp[n - 2]);
        }
    }
}
