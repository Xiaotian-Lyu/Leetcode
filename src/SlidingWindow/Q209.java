package SlidingWindow;

public class Q209 {
    class Solution2 {
        public int minSubArrayLen(int target, int[] nums) {
            int start = 0, end = 0, sum = 0;
            int result = Integer.MAX_VALUE;
            while(end < nums.length){
                sum += nums[end];
                while(sum >= target){
                    result = Math.min(result, end - start + 1);
                    //start upadte
                    sum -= nums[start];
                    start++;
                }
                end++;
            }

            //注意 输出结果的时候要检查一下，最后的result 如果还是最大值的话，那就说明没有找到符合target的值
            return result == Integer.MAX_VALUE ? 0:result;

        }
    }
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
