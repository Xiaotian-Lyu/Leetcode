package prefixSum;

import java.util.HashMap;

public class Q560 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            //map: key-preSum, value- times of appear
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0,1);
            int preSum = 0;
            int result = 0;
            for(int i = 0; i < nums.length; i++){
                preSum += nums[i];
                result += map.getOrDefault(preSum - k,0);
                map.put(preSum, map.getOrDefault(preSum,0) + 1);
            }
            return result;
        }
    }
}
