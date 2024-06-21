package binarytree;

public class Q104 {
    class Solution {
        public int maxDepth(TreeNode root) {
            //root height == tree max Depth
            //DFS - post order - recursion

            if(root == null) return 0;
            if(root.left == null && root.right == null) return 1;//这个条件可以不写，因为下两句代码，已经检查了

            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);

            int result = Math.max(leftDepth, rightDepth) + 1;

            return result;

        }
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
