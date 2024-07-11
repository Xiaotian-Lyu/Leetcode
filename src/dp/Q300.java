package dp;

import java.util.Arrays;

public class Q300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            //initialize dp
            int n = nums.length;
            int[] dp = new int[n];

            Arrays.fill(dp, 1);
            int maxLength = 1;

            for(int i = 0 ; i <= n - 1; i++){
                for(int j = 0; j < i; j++){
                    if(nums[j] < nums[i]){
                        //update the dp[i]
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                    maxLength = Math.max(dp[i], maxLength);
                }
            }

            return maxLength;

        }
    }
}
