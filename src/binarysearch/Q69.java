package binarysearch;

public class Q69 {


    /**
     * 找出符合条件的最大值
     * 就是找出不符合条件的最小值-1
     */
    //右边开区间
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


    class Solution {
        public int mySqrt(int x) {
            //满足条件的右边界
            //找出第一次平方越界的前一个整数
            long left = 0;
            long right = (long)x ;//右边闭区间

            while (left <= right ){//闭区间left = right情况可以存在 可以取到
                long mid = left + (right - left)/2;
                if( mid * mid == x){
                    return (int)mid;
                }else if (mid * mid < x){
                    left = mid +1;
                }else if(mid * mid > x){
                    right = mid - 1;//收缩右边界的时候因为是闭区间，需要舍去已经比较过的闭区间的值
                }
            }
            return (int)(left-1);
        }
    }
}
