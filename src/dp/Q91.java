package dp;

public class Q91 {
    class Solution {
        public int numDecodings(String s) {
            //initialize dp
            int n = s.length();
            int[] dp = new int[n + 1];

            dp[0] = 1;
            //dp[1] = s.charAt(0) == '0' ? 0 : 1; 可以直接比较 ‘0’ 也可以比较数字 / char - '0'
            dp[1] = s.charAt(0) == '0' ? 0 : 1;

            for(int i = 2; i < n + 1; i++){
                // i - 1
                String preOne = s.substring(i - 1, i);
                if(Integer.parseInt(preOne) != 0) dp[i] += dp[i - 1];

                // i - 2
                String preTwo = s.substring(i - 2, i);
                if(Integer.parseInt(preTwo) >= 10 && Integer.parseInt(preTwo) <= 26) dp[i] += dp[i - 2];

            }

            return dp[n];

        }
    }
}
