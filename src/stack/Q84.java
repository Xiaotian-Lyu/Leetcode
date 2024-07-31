package stack;

import java.util.Stack;

public class Q84 {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            //copy the heights and add height 0 in the front and end
            int[] newHeights = new int[heights.length + 2];
            System.arraycopy(heights, 0, newHeights, 1, heights.length);

            //use stack
            Stack<Integer> stack = new Stack<>();
            stack.push(0); //在 stack.peek() 操作之前，没有检查栈是否为空，可能导致抛出 EmptyStackException 异常。所以要先push一个

            //traversal the heights
            int maxArea = 0;
            for(int i = 1; i < newHeights.length; i++){
                while(newHeights[i] < newHeights[stack.peek()]){//这里要用while 比较的是newHeights[stack.peek()]
                    //pop and caluculate the area
                    int indexPop = stack.pop();
                    int heightPop = newHeights[indexPop];//height of the area
                    int leftIndex = stack.peek();
                    int width = i - leftIndex - 1;
                    maxArea = Math.max(maxArea, heightPop * width);
                }
                stack.push(i);//这里push 的是index 要先比较再push
            }

            return maxArea;

        }
    }
}
