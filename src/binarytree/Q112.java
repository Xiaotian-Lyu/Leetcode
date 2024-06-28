package binarytree;

public class Q112 {
    class Solution2 {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            int sum = 0;
            return DFS(root, targetSum, sum);
        }

        //DSF root- left - right preorder
        public boolean DFS(TreeNode root, int targetSum, int sum){
            if(root == null) return false;

            if(root.left == null && root.right == null){
                sum += root.val;
                if(sum == targetSum){
                    return true;//是这一层的返回 true；不是整个function 返回的是 true
                }//else{
                //     return false; 可以不用return false 因为遍历到下一层 判断到root == null 后直接return false
                // }
            }

            return DFS(root.left, targetSum, sum + root.val) || DFS(root.right, targetSum, sum + root.val);

        }
    }
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
