package bitmanipulation;

public class Q191 {
    class Solution {
        public int hammingWeight(int n) {
            int result = 0;

            for(int i = 0; i < 32;i++){
                result += (n >> i) & 1;
            }

            return result;

        }
    }
    // you need to treat n as an unsigned value(无符号整数)
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;//>> - 有符号右移 >>> - 无符号右移：
        }
        return res;
    }
}
