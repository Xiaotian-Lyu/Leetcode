package binarysearchtree;

public class Q538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        helper(root);//错误 写法不需要传参数sum
        return root;
    }

    public void helper(TreeNode root){
        //exit
        if(root == null) return;

        //inorder 升序: left root right  => small - bigger
        //        降序： right root left
        helper(root.right);

        sum += root.val; //calculate the sum of bigger than self
        root.val = sum;//??? 为什么调换顺序也可

        helper(root.left);

    }
}
