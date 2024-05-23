package stack;

import java.util.Stack;

public class Q150 {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();

            for(String token : tokens){
                switch(token){
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;

                    case "-":
                        int n1 = stack.pop();
                        int n2 = stack.pop();
                        stack.push(n2 - n1);
                        break;

                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;

                    case "/":
                        //错误写法：int n1 = stack.pop();
                        //错误写法：int n2 = stack.pop();
                        int n3 = stack.pop();
                        int n4 = stack.pop();
                        stack.push(n4 / n3);
                        break;

                    default:
                        stack.push(Integer.parseInt(token));
                        break;
                }
            }

            return stack.pop();

        }
    }
}
