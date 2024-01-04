package binarytree;

public class Q112 {
    public boolean hasPathSum(TreeNode root,int targetSum){
        int sum = 0;//original sum 0;
        return rootToLeafPathSum(root,targetSum,sum);
    }

    public boolean rootToLeafPathSum(TreeNode root,int targetSum,int sum){
        if(root == null) return false;
        //recursion exit
        if(root.left == null && root.right == null){
            sum += root.val;
            if(sum == targetSum){
                return true;
            }
        }
        //to find out if the left-right leaf
        return rootToLeafPathSum(root.left,targetSum,sum+root.val) ||
                rootToLeafPathSum(root.right,targetSum,sum+root.val);//sum = sum+root.val
    }
}
