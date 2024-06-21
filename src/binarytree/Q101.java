package binarytree;

public class Q101 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            //只能用后序遍历 post order
            //错误回答：并不是比较每个节点的左右子树，只有头节点是这样
            //是比较头节点的两个子节点的
            //exit of the recursion
            if(root == null) return false;//true 也行 false 也行

            return checkChildren(root.left, root.right);
        }

        private boolean checkChildren(TreeNode left, TreeNode right){
            //exit of the recursion
            if(left == null && right == null) return true;//左右 都是 空

            if(left == null || right == null) return false;//左右 只有一个为null

            if(left.val != right.val) return false;//左右 值不等

            //到这一步的left 和 right 左右都非空且值相等 则要去查看下一层的值

            boolean nextCheck = checkChildren(left.left, right.right)&&checkChildren(left.right, right.left);

            return nextCheck;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        //include three case:
        //1-left = null && right != null
        //2-left != null && right = null
        //3-left.val != right.val
        else if (left == null || right == null || left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
