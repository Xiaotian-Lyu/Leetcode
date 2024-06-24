package binarysearchtree;

import binarytree.TreeNode;

public class Q98 {
    class Solution {
        boolean result = true;
        Integer preValue = null;
        // root = [-2147483648]  -231 <= Node.val <= 231 - 1

        public boolean isValidBST(TreeNode root) {
            helper(root);
            return result;
        }
        //inorder - DFS
        public void helper(TreeNode root){
            //exit of the recusion
            if(root == null){
                return;
            }

            //left
            helper(root.left);

            //root
            if(preValue != null){
                if(preValue >= root.val){
                    result = false;
                    return;
                }
            }
            preValue = root.val;


            //right
            helper(root.right);

        }
    }
    //check the node.val : left < root < right
    public boolean isValidBST(binarytree.TreeNode root) {
        return helper(root,null,null);//错误写法helper(root,0,0)初始化是0的时候不能比较负数root = [0,null,-1]
    }

    //recursion
    public boolean helper(binarytree.TreeNode root, binarytree.TreeNode minNode, TreeNode maxNode){//错误写法：helper(TreeNode root,int minVal,int maxVal)
        //exit of the recursion
        //if we reach the leaf and don't return false then must be true
        if(root == null) return true;

        //check the value
        if(maxNode != null && root.val >= maxNode.val) return false;
        if(minNode != null && root.val <= minNode.val) return false;

        return helper(root.left,minNode,root)&&helper(root.right,root,maxNode);
    }

}
