package arraryandstring;

public class Q50 {
    class Solution {
        public double myPow(double x, int n) {
            if(n < 0){
                x = 1 / x;
                n = - n;
            }
            return helper(x, n);

        }

        public double helper(double x, long n){
            //exit of the recursion
            if(n == 0) return 1.0;
            if(n == 1) return x;

            if(n % 2 == 0){
                return helper(x * x, n / 2);
            }else{
                return x * helper(x * x, n / 2);
            }

            //return？

        }
    }
}
