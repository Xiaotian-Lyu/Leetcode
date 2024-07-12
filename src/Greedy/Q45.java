package Greedy;

public class Q45 {
    class Solution {
        public int jump(int[] nums) {
            int steps = 0;
            int currentEnd = 0;
            int maxPostion = 0;

            //for(int i = 0; i <= nums.length - 1; i++){ 错误写法
            for(int i = 0; i < nums.length - 1; i++){
                //错误写法：maxPostion = i + nums[i];
                maxPostion = Math.max(i + nums[i], maxPostion);
                if(i == currentEnd){
                    steps++;
                    currentEnd = maxPostion;
                }
            }

            return steps;

        }
    }
}
