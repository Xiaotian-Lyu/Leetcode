package binarytree;

import com.sun.jdi.Value;
import com.sun.source.tree.Tree;

public class Q530 {
    int result = Integer.MAX_VALUE;// finding the minimum, so initialize max value
    int pre = Integer.MAX_VALUE;//a pre the store the last TreeNode

    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return result;
    }

    public void inOrderTraversal(TreeNode node) {
        if (node.left != null) inOrderTraversal(node.left);//recursion condition
        //calculate the difference of each node
        result = Math.min(result,Math.abs(node.val-pre));
        //update the pre
        pre = node.val;
        if (node.right != null) inOrderTraversal(node.right);//recursion condition
    }
}
