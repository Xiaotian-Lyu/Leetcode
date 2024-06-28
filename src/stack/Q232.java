package stack;

import java.util.Stack;

public class Q232 {
    class MyQueue {

        Stack<Integer> inStack;
        Stack<Integer> outStack;

        public MyQueue() {
            //use two stack
            //错误 Stack<Integer> inStack = new Stack<>();
            //错误 Stack<Integer> outStack = new Stack<>();
            this.inStack =  new Stack<>();
            this.outStack =  new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if(outStack.isEmpty()){
                //put instack into outstack
                while(!inStack.isEmpty()){
                    outStack.push(inStack.pop());
                }
            }
            return outStack.pop();
        }

        public int peek() {
            if(outStack.isEmpty()){
                //put instack into outstack
                while(!inStack.isEmpty()){
                    outStack.push(inStack.pop());
                }
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();

        }
    }

    Stack<Integer> inStack = new Stack<Integer>();//为什么要是Integer
    Stack<Integer> outStack = new Stack<Integer>();


    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {//如果outStack 非空就不能执行
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.empty() && outStack.empty();//empty 和 isEmpty 都可以
    }
}
