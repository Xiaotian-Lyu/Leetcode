package SlidingWindow;

public class Q209 {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            //错误写法：res = Integer.MaxValue;
            int i = 0, j = 0, res = Integer.MAX_VALUE;
            int sum = 0;
            //错误写法：j < nums.length()
            while(j < nums.length){
                sum += nums[j];
                while(sum >= target){
                    res = Math.min(res, j-i+1);
                    sum -= nums[i];
                    i++;
                }
                j++;
            }
            return res == Integer.MAX_VALUE ? 0 : res;

        }
    }
}
