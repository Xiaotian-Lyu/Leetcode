package string;

public class Q409 {
    public int longestPalindrome(String s) {
        int[] count = new int[256];//需要区分大小写 所以用hash表
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        boolean flag = false;//判断是否存在单一的中心值
        int res = 0;
        for (int i : count) {
            if (i % 2 != 0) {
                flag = true;
                res += res / 2 * 2;//区分python的写法
            }
        }
        return flag ? res + 1 : res;
    }
}
