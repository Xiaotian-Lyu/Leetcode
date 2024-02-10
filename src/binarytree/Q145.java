package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        //postorder:left - right - root
        //in the stack sequence(push):root   check and push:left - right
        //in the list sequence(addFirst):left-right-root

        Stack<TreeNode> stack = new Stack<>();//use the feature of stack: first in last out
        LinkedList<Integer> res = new LinkedList<>();//错误写法List<Integer> res = new ArrayList

        if(root == null) return res;//错误写法 return null
        //push the root
        stack.push(root);

        while(!stack.isEmpty()){//错误写法!stack.isEmpty
            TreeNode node = stack.pop();
            res.addFirst(node.val);

            //check and push:left - right
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        return res;

    }
}
