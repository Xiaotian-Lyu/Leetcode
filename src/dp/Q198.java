package dp;

public class Q198 {
    class Solution {
        public int rob(int[] nums) {
            int[] result = new int[nums.length];

            //if only 1 house //错误写法 这个时候result[0]还没付值 默认是0
            //if(nums.length == 1) return result[0];
            if(nums.length == 1) return nums[0];
            result[0] = nums[0];
            result[1] = Math.max(nums[0],nums[1]);

            for(int i = 2; i < nums.length; i++){
                result[i] = Math.max(nums[i]+ result[i - 2], result[i - 1]);
            }

            return result[nums.length - 1];
        }
    }
}
