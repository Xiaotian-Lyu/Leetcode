package dp;

public class Q70 {
    public int climbStairs(int n) {
        if(n <= 1) return 1;

        int[] res = new int[n + 1];//别忘了new
        res[0] = 1;
        res[1] = 1;

        for(int i = 2; i <= n; i++){
            res[i] = res[i-1] + res[i-2];//依托前面的两步
        }

        return res[n];
    }
}
