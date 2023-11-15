package arrary;

public class Q121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int min = prices[0];//初始化最小值
        int pro = 0;//初始化盈利
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min,prices[i]);
            pro = Math.max(pro,prices[i]-min);
        }
        return pro;
    }

}
