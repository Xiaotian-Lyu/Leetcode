package hashmap;

import java.util.HashSet;
import java.util.Set;

public class Q128 {
    class Solution2 {
        public int longestConsecutive(int[] nums) {
            //错误写法：HashSet<int[]> set = new HashSet<>(nums);
            //接受集合（如 ArrayList、LinkedList）
            Set<Integer> set = new HashSet<>();
            for(int n : nums){
                set.add(n);
            }

            int res = 0;

            for(int i = 0; i < nums.length; i++){
                //check if it is the beginning 
                if(!set.contains(nums[i]-1)){
                    int cur = nums[i]; //the beginning cur
                    int count = 1;
                    while(set.contains(nums[i]+ 1)){
                        count++;
                        nums[i]++;
                    }
                    res = Math.max(res, count);
                }
            }
            return res;
        }
    }
    class Solution {
        public int longestConsecutive(int[] nums) {
            //Hashset - without duplicate nums
            Set<Integer> sets = new HashSet<>();//错误写法：new Hashset<>();
            for(int num : nums){
                sets.add(num);
            }


            int res = 0;
            //traversal num
            //for (int num : nums) ？
            //for 里面有while 循环 时间复杂度？
            for(int set : sets){
                //check if the beginner
                if(!sets.contains(set -1)){
                    int count = 1;
                    while(sets.contains(set+1)){
                        count++;
                        set++;
                    }
                    //max(count , res)
                    res = Math.max(res, count);
                }

            }
            //return res
            return res;
        }
    }
}
