package arraryandstring;

import java.util.HashMap;
import java.util.Map;

public class Q169 {
    class Solution2 {
        public int majorityElement(int[] nums) {
            //transfer nums to hashmap
            HashMap<Integer,Integer> map = new HashMap<>();

            for(int i = 0; i < nums.length;i++){
                if(map.containsKey(nums[i])){
                    //map.get(i)
                    map.put(nums[i], map.get(nums[i]) + 1);
                }else{
                    map.put(nums[i],1);
                }
            }

            //check all the value
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                if(entry.getValue() > nums.length/2){
                    return entry.getKey();
                }
            }
            return -1;
        }
    }
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate){
                count++;
            }else {
                count--;
            }
        }
        return candidate;
    }
}
