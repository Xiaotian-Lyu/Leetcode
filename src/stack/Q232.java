package stack;

import java.util.Stack;

public class Q232 {
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
