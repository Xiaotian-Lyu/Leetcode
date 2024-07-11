package dp;

import java.util.Arrays;

public class Q322 {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            //dp
            int[] dp = new int[amount + 1];

            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] =0;

            //traversal
            for(int i = 0; i <= amount; i++){
                for(int coin : coins){
                    if(i >= coin && dp[i - coin] != Integer.MAX_VALUE){
                        dp[i]= Math.min(dp[i], dp[i - coin] + 1);//output is step
                    }
                }
            }

            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
}
