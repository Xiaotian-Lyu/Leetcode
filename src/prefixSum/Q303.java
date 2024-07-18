package prefixSum;

public class Q303 {
    class NumArray {
        //attribution
        int[] preSum;

        public NumArray(int[] nums) {
            preSum = new int[nums.length + 1];
            int sum = 0;
            for(int i = 0; i < nums.length ; i++){
                sum += nums[i];
                preSum[i + 1] = sum;
            }

        }

        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }

}
