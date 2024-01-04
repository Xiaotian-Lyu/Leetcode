package binarytree;

public class Q101 {
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
