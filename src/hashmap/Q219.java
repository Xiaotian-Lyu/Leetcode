package hashmap;

import java.util.HashMap;
import java.util.Map;

public class Q219 {
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            //use map: key-num value-index
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                //check if contains Key
                if(map.containsKey(nums[i])){
                    int index = map.get(nums[i]);
                    int result = i - index;
                    if(result <= k) return true;
                    // }else{
                    // return false;//当前代码在找到一个不满足距离 k 的重复元素时立即返回 false。
                    //这是不正确的，因为数组中可能还有其他满足条件的重复元素。

                }
                //这里改动---- 可以重复比较更新或插入当前元素的索引[1,0,1,1]
                map.put(nums[i], i);
            }

            return false;
        }
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //a hashmap to store the array values and index
        Map<Integer, Integer> map = new HashMap<>();

        //traversal the nums to compare the index
        for (int i = 0; i < nums.length; i++) {
            /**
             先比较 再放值-第18行的原因是:先放值会导致——出现重复的值会被误判
             例如 nums=[1,2,1] 的情况
             i=0 map.value=0 key=1 *
             i=1 map.value=1 key=2
             i=2 map.value=2 key=1 * 这里出现相同key 直接把 原来1对应的value0  改成了2
             */
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            //不建议改顺序map.put(i, nums[i]);
            //原因：从map 中找key 很迅速O1；
            // 从key 找value 很快（判断value—>nums[i] 出现重复则看index i的值）
            //反之：去一个map里找value 要逐个遍历
            map.put(nums[i], i);
        }

        return false;

    }
}
