package twopointers;

public class Q977 {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] res = new int[nums.length];
            // keep the final result index
            int resIndex = nums.length - 1;
            // two pointers
            int left = 0, right = nums.length - 1;
            while(left <= right){
                int leftValue = nums[left];
                int rightValue = nums[right];
                if(Math.abs(leftValue) > Math.abs(rightValue) ){
                    res[resIndex] = leftValue * leftValue;
                    left++;
                }else{
                    res[resIndex] = rightValue * rightValue;
                    right--;
                }
                resIndex--;//upadate the result index
            }

            return res;

        }
    }
}
