package arrary;

import java.util.HashMap;
import java.util.Map;

public class Q1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;


//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement) && map.get(complement) != i){
//                return new int[]{i,map.get(complement)};
//            }
//        }
//        //In case there is no solution we'll return null
//        return null; //时间复杂度是2n 还可以继续优化


//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                int x = nums[i] + nums[j];
//                if (x == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[]{};
//时间复杂度是n*n 效率太低


    }
}
