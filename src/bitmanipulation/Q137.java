package bitmanipulation;

import java.util.Arrays;

public class Q137 {
    class Solution {
        public int singleNumber(int[] nums) {
            Arrays.sort(nums);
            //排序后有三种可能，只出现一次的数字在index 0 或者 末尾 或者 中间
            //开始和中间 用if (nums[i] == nums[i + 1])判断
            //return nums[nums.length - 1];末尾直接用这个返回，nums[i + 1]超出范围

            for (int i = 0; i < nums.length - 1; i += 3) {
                //范围防止越界 i < nums.length ; i+1 < nums.length
                if (nums[i] == nums[i + 1]) {
                    continue;
                } else {
                    //不能省略
                    //例外情况[30000,500,100,30000,100,30000,100]
                    //排序后是[100,100,100,500,30000,30000,30000]
                    return nums[i];
                }
            }

            return nums[nums.length - 1];
        }
    }
}
