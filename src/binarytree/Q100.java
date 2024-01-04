package binarytree;

public class Q100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
//        if (p == null || q == null || p != q) return false;"p != q" 一定不等 比较的是地址值 我们要比较value
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
