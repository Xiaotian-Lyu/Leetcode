package binarytree;

public class Q226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = root.left;//先保留左边的值
        root.left = invertTree(root.right);//改变左边的值
        root.right = invertTree(left);//将之前保留的值放到右边去
        return root;
    }
}
