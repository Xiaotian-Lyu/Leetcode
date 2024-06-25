package binarytree;

public class Q124 {
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
