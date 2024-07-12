package dp;

public class Q152 {
    class Solution {
        public int maxProduct(int[] nums) {
            //initialize the dp
            int n = nums.length;
            int[] maxDp = new int[n];
            int[] minDp = new int[n];
            //不能忘起点
            maxDp[0] = nums[0];
            minDp[0] = nums[0];

            int maxProduct = nums[0];

            for(int i = 1; i < n; i++){//i= 0 的时候已经初始化了
                if(nums[i] < 0){
                    maxDp[i] = Math.max(nums[i] * minDp[i - 1], nums[i]);
                    minDp[i] = Math.min(nums[i] * maxDp[i - 1], nums[i]);
                }else{
                    maxDp[i] = Math.max(nums[i] * maxDp[i - 1], nums[i]);
                    minDp[i] = Math.min(nums[i] * minDp[i - 1], nums[i]);
                }
                maxProduct = Math.max(maxProduct, maxDp[i]);
            }

            return maxProduct;

        }
    }
}
