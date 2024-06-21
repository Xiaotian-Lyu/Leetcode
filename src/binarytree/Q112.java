package binarytree;

public class Q112 {
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            // if(root == null) return false; 这句可以不写
            int sum = 0;

            return DFS(root, targetSum, sum);
        }

        public boolean DFS(TreeNode root, int targetSum, int sum){

            if(root == null) return false;//调用recursion的那个函数 是DFS
            //exit of the recursion
            if(root.left == null && root.right == null){
                sum += root.val;
                if(sum == targetSum){
                    return true;
                }else{
                    return false;
                }
            }

            return DFS(root.left, targetSum, sum + root.val) || DFS(root.right, targetSum, sum + root.val);

        }
    }
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
