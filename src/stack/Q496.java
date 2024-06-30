package stack;

import java.util.HashMap;
import java.util.Stack;

public class Q496 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            //stack to compare the value of nums2
            Stack<Integer> stack = new Stack<>();

            //hashmap to keep the (key:nums2.  value:bigger than it self)
            HashMap<Integer,Integer> map = new HashMap<>();

            for(int num : nums2){
                //check if has the number bigger than self
                while(!stack.isEmpty() && num > stack.peek()){
                    map.put(stack.pop(), num);
                }
                stack.push(num);
            }

            //traversal num1 get the result from map
            int[] result = new int[nums1.length];
            for(int i = 0; i < nums1.length ; i++){
                //错误写法：result[i] = map.getOrDefault(result[i], -1);
                result[i] = map.getOrDefault(nums1[i], -1);
            }

            //return
            return result;

        }
    }
}
