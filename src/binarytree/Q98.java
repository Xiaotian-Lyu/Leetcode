package binarytree;

public class Q98 {
    //check the node.val : left < root < right
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);//错误写法helper(root,0,0)初始化是0的时候不能比较负数root = [0,null,-1]
    }

    //recursion
    private boolean helper(TreeNode root,TreeNode minNode,TreeNode maxNode){//错误写法：helper(TreeNode root,int minVal,int maxVal)
        //exit of the recursion
        //if we reach the leaf and don't return false then must be true
        if(root == null) return true;

        //check the value
        if(maxNode != null && root.val >= maxNode.val) return false;
        if(minNode != null && root.val <= minNode.val) return false;

        return helper(root.left,minNode,root)&&helper(root.right,root,maxNode);
    }

}
