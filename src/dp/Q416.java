package dp;

public class Q416 {
    class Solution {
        public boolean canPartition(int[] nums) {
            //check sum of nums ：even or odd
            int sum = 0;
            for(int num : nums){
                sum += num;
            }

            //odd return false
            if(sum % 2 != 0 ) return false;

            //get the target is half sum
            int target = sum / 2;

            //use dp to find subsets = half sum
            boolean[][] dp = new boolean[nums.length][sum + 0];

            //base case
            for(int i = 0; i < nums.length; i++){
                dp[i][0] = true;//dp[0][0] = true
            }
            for(int j = 1; j < target + 1; j++){
                dp[0][j] = false;
            }

            //traversal the 2D int[i][j]: i = numbers, j = target sum
            // i = 0 和 j = 0 都比较过了 是base case
            for(int i = 1; i < nums.length; i++){
                for(int j = 1; j < target + 1; j++){
                    if(j >= nums[i]){
                        dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                    }else{
                        dp[i][j] = dp[i - 1][j];
                    }

                }
            }

            //return dp
            return dp[nums.length - 1][target];
        }
    }
}
