package Google;

public class MaximizeP {
    public int maximizePoints(int[] points) {
        // write your code here
        //dp 和抢房子不一样
        int n = points.length;

        if (n == 0) return 0;
        if (n == 1) return points[0];

        int[] dp = new int[n + 1];//dp[i]表示从i开始的最大点数
        dp[n] = 0;

        for(int i = n - 1; i >= 0; i--){
            int take = points[i];
            if(i + points[i] < n){
                take += dp[i + points[i] + 1];
            }
            dp[i] = Math.max(take, dp[i + 1]);
        }
        return dp[0];
    }

    public int maximizePoints2(int[] points) {
        // write your code here 用recursion
        return dfs(points, 0);
    }

    public int dfs(int[] points,int index){
        //exit of the recursion
        if(index >= points.length){
            return 0;
        }

        int notTake = dfs(points, index + 1);
        int nextIndex = index + points[index] + 1;
        int takeHere = points[index] + dfs(points, nextIndex);

        int max = Math.max(notTake, takeHere);
        return max;
    }

    public static void main(String[] args){
        MaximizeP test = new MaximizeP();
        System.out.println(test.maximizePoints(new int[]{25, 1, 3, 99, 4}));  // 输出应为9

        System.out.println(test.maximizePoints2(new int[]{25, 1, 3, 99, 4}));
    }
}
