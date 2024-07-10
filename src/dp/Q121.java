package dp;

public class Q121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int buy = prices[0];
            int maxPro = 0;
            //traversal the sell day,and buy day
            for(int i = 1; i < prices.length; i++){
                buy = Math.min(buy, prices[i]);//find the min buy
                maxPro = Math.max(maxPro, prices[i] - buy);//get the max pro
            }

            return maxPro;

        }
    }
}
