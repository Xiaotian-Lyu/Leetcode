package binarysearchtree;

import binarytree.TreeNode;

public class Q230 {
    //inorder : left root right
    //feature:  small to  big
    int count = 0;
    int res = 0;

    public int kthSmallest(binarytree.TreeNode root, int k) {
        helper(root,k);
        return res;
    }

    private void helper(TreeNode root, int k){
        //exit of the recursion
        if(root == null){
            return;
        }

        //check the left first
        helper(root.left,k);

        //check self
        count++;
        if(count == k){
            res = root.val;
        }

        //check the right
        helper(root.right,k);
    }

}
