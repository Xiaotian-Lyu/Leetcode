package dp;

public class Q53{
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
