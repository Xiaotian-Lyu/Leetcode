package binarysearch;

public class Q69 {


    /**
     * 找出符合条件的最大值
     * 就是找出不符合条件的最小值-1
     */
    public int mySqrt1(int x) {
        long left = 0;
        long right = (long)x + 1;//注意这里的边界 最大的整数+1是负数

        while (left < right){
            long mid = left + (right - left)/2;
            if( mid * mid == x){
                left = mid + 1;
            }else if (mid * mid < x){
                left = mid + 1;
            }else if(mid * mid > x){
                right = mid;
            }
        }
        return (int) (left-1);
    }
    public int mySqrt2(int x) {
        if (x == 0 || x == 1) return x;

        //binary search
        long left = 0;//都要是long才能运算
        long right = x;
        long res = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;//mid*mid 会超出0 <= x <= 2^31 - 1
            if (mid * mid == x) {
                return (int) mid;// find the mid / (int) mid-强制转换
            } else if (mid * mid < x) {
                left = mid + 1;
                res = mid;//keep the mid as result in case the next one > x;
            } else if (mid * mid > x) {
                right = mid - 1;
            }
        }

        return (int) res;

    }
}
