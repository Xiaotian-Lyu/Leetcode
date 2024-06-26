package binarytree;

public class Q124 {
    class Solution2 {
        int result = Integer.MIN_VALUE;//-1000 <= Node.val <= 1000
        public int maxPathSum(TreeNode root) {
            DFS(root);//DFS 返回的是这个根节点 的最大sum的一条path
            return result;
        }

        //DFS - post order - return one side path sum
        public int DFS(TreeNode root){
            //exit of the rexursion
            if(root == null) return 0;

            //left- if this sum is smaller than 0; just do not count that way
            int left = Math.max(0, DFS(root.left));

            //right
            int right = Math.max(0, DFS(root.right));

            //reslut
            result = Math.max(left + right + root.val, result);
            //update result 我们求的result 在这里不断update
            //和之前的path sum 不一样的是 之前的sum 需要把自己val 传递下去 直到叶子结点 才能判断是否符合条件
            //但这一题需要先知道左边path的sum 和 右边 path的sum 才能算出 Max pathsum

            return Math.max(left, right) + root.val;
        }
    }
    class Solution {
        int result = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            int sum = 0;
            helper(root,0);
            return result;
        }

        public int helper(TreeNode root, int sum){
            if(root == null) return 0;

            int left = Math.max(0,helper(root.left, sum + root.val));

            int right = Math.max(0,helper(root.right, sum + root.val));

            result = Math.max(result, left + right + root.val);

            return left + right +root.val;

            /**
             返回一条从当前节点向下走的最大单边路径和：用于递归计算父节点的路径和。
             直接返回 left + right + root.val 不满足第二个条件，因为这个值表示当前节点为根的完整路径和，
             但在递归中，我们需要的是从当前节点到叶子节点的单边最大路径和来进行进一步的计算。
             */
        }
    }
}
