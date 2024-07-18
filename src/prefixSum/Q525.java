package prefixSum;

import java.util.HashMap;

public class Q525 {
    class Solution {
        public int findMaxLength(int[] nums) {
            HashMap<Integer, Integer> map= new HashMap<>();
            //key: preSum. value: index
            map.put(0, -1);
            int preSum = 0;
            int result = 0;
            for(int i = 0; i < nums.length; i++){
                preSum += nums[i] == 1 ? 1 : -1;
                if(map.containsKey(preSum)){
                    result = Math.max(result , i - map.get(preSum));
                }else{
                    map.put(preSum, i);
                }
            }
            return result;
        }
    }
}
