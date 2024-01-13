package bitmanipulation;

public class Q190 {
    public class Solution {
        // you need treat n as an unsigned value（无符号整数）
        /**不用这个乘除运算的原因是因为第一个数是1的话代表负数
         * 如果全是正整数的话是OK的
         * tail = n & 1  「 tail = n % 2 」取余数
         * res = (res << 1) | tail;   「res = res*2 + tail 」
         * n >>= 1  「 n = n/2 」
         */
        public int reverseBits(int n) {
            long res = 0;
            for (int i = 0; i < 32; i++) {
                int tail = n & 1;//& ｜  只和最后一位运算
                res = (res << 1) | tail;
                n >>>= 1;//>> - 有符号右移 >>> - 无符号右移：
            }
            return (int )res;
        }
    }
}
