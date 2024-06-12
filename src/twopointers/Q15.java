package twopointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> res = new LinkedList<>();
            //不能忘sort
            Arrays.sort(nums);
            for(int i = 0; i < nums.length ; i++){
                if(i > 0 && nums[i] == nums[i - 1]) continue;
                int target = 0 - nums[i];
                int left = i + 1, right = nums.length - 1;//这里保证了三个数字不重复
                while( left < right ){
                    int sum = nums[right] + nums[left];
                    if( sum == target){
                        //错误写法：res.add(new int[]{nums[i], nums[left], nums[right]});
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        //错误写法：while(nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right] == nums[right - 1]) right--;
                        //不能忘记，上面两句话是去重 下面两句是遍历
                        left++;
                        right--;
                    }else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }

            return res;
        }
    }
}
