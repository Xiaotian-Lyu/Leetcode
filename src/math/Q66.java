package math;

public class Q66 {
    public int[] plusOne(int[] digits) {
        //traversal the digits from the end:
        for (int i = digits.length - 1; i >= 0; i--) {
            //1.num < 9
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;//digits[i++]错误。而是 digits[i]++;
                return digits;
            }
            //2.num = 9;9+1=10
            digits[i] = 0;
        }
        //if after the for loop there is no return:means 999999
        int[] res = new int[digits.length + 1];//new int[]这里是中括号
        res[0] = 1;//初始化 数组 都是默认0
        return res;
    }
}
