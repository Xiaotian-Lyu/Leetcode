package bitmanipulation;

public class Q201 {
    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            //Bitwise-AND of any two numbers will
            //always produce a number less than or equal to the smaller number.
            /**
             这种行为源于按位与运算的性质。当你对两个数字进行按位与运算时，每一位上的结果取决于两个数字对应位上的值。
             考虑两个二进制数a和b进行按位与运算：
             如果a的某一位为0，b的对应位为0或1，结果位将为0。
             如果a的某一位为1，b的对应位为0，结果位也将为0。
             只有当a和b的对应位都为1时，结果位才为1。
             12 ---- 1100
             11 ---- 1011
             10 ---- 1010
             9  ---- 1001
             8  ---- 1000
             7  ---- 0111
             6  ---- 0110
             5  ---- 0101

             Desired Range: [5,12]

             Starting from 12, the loop will first do
             12 & 11 = 8

             Next iteration, the loop will do
             8 & 7 = 0

             why did we skip anding of 10,9? Because even if we did so, the result would eventually be anded with 8 whose value would be lesser than equal to 8.

             Hence, you start from the range end and keep working your way down the range till you reach the start.
             */
            //while m = n; return n, will not go into the while loop
            //时间复杂度是O1 是一个常数n 可以被忽略
            while (m < n)
                n = n & (n - 1);
            return n;
        }
    }
}
