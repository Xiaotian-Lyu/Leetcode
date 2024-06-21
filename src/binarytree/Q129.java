package binarytree;

public class Q129 {
    class Solution {

        public int sumNumbers(TreeNode root) {

            return DFS(root, 0);
        }

        int result = 0;

        public int DFS(TreeNode root, int preval){
            if(root == null) return 0;
            preval = preval * 10 + root.val;

            //exit of the recursion
            if(root.left == null && root.right == null){
                result += preval;
            }

            DFS(root.left, preval);
            DFS(root.right, preval);

            return result;

        }
    }
    int res = 0;

    public int sumNumbers(TreeNode root) {
        helper(root,0);//错误写法 return helper(root,0)
        return res;//返回值定义在方法外面的原因
    }


    //deep first search
    public void helper(TreeNode root , int preVal){
        if(root == null) return;

        //if reach the leaf node ，add the sum of res together
        if(root.left == null && root.right == null){
            res += preVal * 10 + root.val;
            return;
        }

        // recursion
        helper(root.left,preVal * 10 + root.val);
        helper(root.right,preVal * 10 + root.val);
    }
}
