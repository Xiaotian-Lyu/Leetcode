package binarytree;

public class Q236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //exit of the recursion
        if(root == null) return root;//null
        //find both p or q return
        if(root == p || root == q) return root;
        //错误写法(root.left != null || root.right != null) 递归部分在下面的两行代码 这里只要判断当前节点root 就行

        //we need to check leaf node if it is : p / q
        //recursion
        TreeNode left = lowestCommonAncestor(root.left,p,q);//错误写法接收node lowestCommonAncestor(root.left,p,q)
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        //reach the leaf node there are three case
        if(left != null && right != null) return root;//find both p/q in both side
        if(left != null && right == null) return left;//find the left side have p/q

        //错误写法if(left == null && right != null) return right;没有return了
        return right;

    }
}
