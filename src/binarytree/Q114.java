package binarytree;

public class Q114 {
    public void flatten(TreeNode root) {
        //recursion exit
        if(root == null) return;//错误写法 if(root == null) return null;

        //recursion
        flatten(root.left);
        flatten(root.right);

        //keep the original right subtree
        TreeNode temp = root.right;

        //change the root.right
        root.right = root.left;
        root.left = null;

        //find the last new right subtree //错误写法用 if(root.right != null) 来判断
        while(root.right != null){
            root = root.right;
        }

        //put the original right in the end
        root.right = temp;

    }
}
