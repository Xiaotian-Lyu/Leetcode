package dp;

public class Q53{
    class Solution2 {
        public int maxSubArray(int[] nums) {
            int sum = nums[0];
            int result = nums[0];//在只有一个数的情况下result就= nums[0]
            //int result = Integer.MIN_VALUE;错误写法
            for(int i = 1; i < nums.length; i++){
                if(sum > 0){//前面的sum >0 才相加
                    sum += nums[i];
                }else{
                    //不能忽略小于0的情况也需要处理 只写上半部分就= 把所有正数都加起来而已
                    sum = nums[i];//前面的sum < 0 就把利益最大化只加自己不管是正数还是负数 下一步会自己判断
                }

                result = Math.max(result, sum);
            }

            return result;
        }
    }
    class Solution {
        public int maxSubArray(int[] nums) {
            int sum = nums[0];
            int result = nums[0];

            for(int i = 1; i < nums.length; i++){
                if(sum > 0){
                    sum = sum + nums[i];
                }else{// sum <=0
                    sum = nums[i];
                }

                result = Math.max(result, sum);
            }

            return result;

        }
    }
}
