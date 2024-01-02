package binarysearchtree;

public class Q235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if( root == null) return null; 下面一行用了if语句的话，这句话是废话
//        if (root != null){
//            //1.if the root value bigger than p and q ——> root.left
//            while (root.val > p.val && root.val > q.val){//忽略了 先需要往右边走的 可能性
//                root = root.left;
//            }
//            //2.if the root value smaller than p and q ——> root.right
//            while (root.val < p.val && root.val < q.val){
//                root = root.right;
//            }
//
//        }
//        //3.else root is the lowest common ancestor
//        return root;
         if( root == null) return null;
         while(root != null){
             if(root.val > p.val && root.val > q.val){
                 root = root.left;
             }else if(root.val < p.val && root.val < q.val){
                 root = root.right;
             }else {
                 return root;// root is the lowest common ancestor return root
             }
         }
         return null;// can not find the root return null
    }

}
