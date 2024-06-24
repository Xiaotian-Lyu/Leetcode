package binarytree;

import binarytree.TreeNode;
import model.ListNode;

public class Q110 {
    class Solution {//这种方式用了两次recursion
        public boolean isBalanced(TreeNode root) {
            if(root == null) return true;

            //check if balanced
            int left = height(root.left);
            int right = height(root.right);
            if(Math.abs(left - right) < 2 && isBalanced(root.left) && isBalanced(root.right) ) return true;

            return false;

        }
        //get the height of each node
        public int height(TreeNode root){
            if(root == null) return -1;

            //left side
            int left = height(root.left);

            //right side
            int right = height(root.right);

            return 1 + Math.max(left,right);
        }
    }
    Boolean res = true;// 默认是True

    //create a method to know if it is a balanced tree
    public boolean isBalanced(binarytree.TreeNode root) {//TreeNode 和 ListNode 区分
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left - right) > 1) res = false;//if 求绝对值 abs >1 that means is not balance
        return Math.max(left, right) + 1;
    }
}
