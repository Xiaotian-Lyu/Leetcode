package binarytree;

public class Q543 {
    int res = 0;//有两个方法需要用到

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res = Math.max(res, left + right);//this res change and the last method will get the number
        return Math.max(left, right) + 1;
    }
}
