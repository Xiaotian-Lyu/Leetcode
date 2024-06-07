package dp;

public class Q70 {
    class Solution {
        public int climbStairs(int n) {
            if(n <= 1) return 1;

            int[] res = new int[n + 2];//input=n ,我们要找的也是n
            res[1] = 1;//一个台阶 一种可能
            res[2] = 2;//两个台阶 两种可能

            for(int i = 3; i <= n; i++){
                res[i] = res[i-1] + res[i-2];//依托前面的两步
            }

            return res[n];
        }
    }
}
