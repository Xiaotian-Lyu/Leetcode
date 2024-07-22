package twopointers;

public class Q42 {
    class Solution {
        public int trap(int[] height) {
            //two pointer
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            int result = 0;

            while(left < right){
                //get the max left and right
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);

                if(leftMax < rightMax){
                    //left Max can decide the max hight of water
                    result += leftMax - height[left];//左边的最大值 只能和坐标形成积水，它不一定是右坐标的最大值
                    left++;
                }else{
                    result += rightMax - height[right];//右坐标的最大值只能和右坐标形成积水
                    right--;
                }

            }
            return result;

        }
    }
}
