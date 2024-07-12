package Greedy;

public class Q55 {
    class Solution {
        public boolean canJump(int[] nums) {
            /**
             [2,3,1,1,4]
             index       [0,1,2,3,4]
             maxpostion  [2,3,4,4,8]

             */

            int maxposition = 0;

            for(int i = 0; i < nums.length; i++){
                //check if can reach the i place
                if(i > maxposition) return false;
                //update maxposition
                maxposition = Math.max(maxposition, i + nums[i]);
            }

            return true;

        }
    }
}
