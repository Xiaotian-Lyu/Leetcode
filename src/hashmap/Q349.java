package hashmap;

import java.util.HashSet;
import java.util.Set;

public class Q349 {
    public class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();

            for(int num : nums1){
                set1.add(num);
            }

            for(int num : nums2){
                //错误写法：if(set1.containsKey(num)){
                if(set1.contains(num)){
                    set2.add(num);
                }
            }

            int[] res = new int[set2.size()];
            int index = 0;
            for(int intersection : set2){
                //错误写法：res.add(intersection);
                res[index++] = intersection;
            }

            return res;

        }
    }
}
