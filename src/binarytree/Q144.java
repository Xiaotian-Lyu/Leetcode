package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        //root - left - right

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;
        //first to push root
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();//first to pop root
            res.add(node.val);//不要把这一步忘了

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;//不要忘了这一步
    }
}
