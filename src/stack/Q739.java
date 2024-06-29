package stack;

import java.util.Stack;

public class Q739 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] result = new int[temperatures.length];
            //stack to keep the index of temperatures
            Stack<Integer> stack = new Stack<>();
            //traversal the temperatures
            for(int i = 0; i < temperatures.length; i++){
                //keep put the index into the stack until find temperature > i
                //错误写法：while(!stack.isEmpty() && temperatures[i] < temperatures[stack.pop()]){
                //peek 先比较，确认i 比较大了再 pop
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    result[stack.peek()] = i - stack.pop();
                }
                stack.push(i);
            }
            return result;

        }
    }
}
