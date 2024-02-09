package binarytree;

import java.util.Stack;

public class Q173 {
    //left - root - right
    Stack<TreeNode> stack = new Stack<>();

    public Q173(TreeNode root) {
        push(stack,root);
    }

    //push method from root to left leaf
    public void push(Stack<TreeNode> stack, TreeNode root){
        while(root!= null){//until to reach leaf
            stack.push(root);
            root = root.left;
        }
    }

    public int next(){
        while(!hasNext()) return -1;
        TreeNode node = stack.pop();
        push(stack,node.right);//check the right side
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

}
