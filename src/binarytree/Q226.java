package binarytree;

public class Q226 {
    class Solution {
        class Solution2 {
            public TreeNode invertTree(TreeNode root) {
                //最后return 的是root，只需要改变左右子树 就行不需要额外参数 不写另外的function也行

                if(root == null) return root;

                TreeNode temp = root.left;
                root.left = invertTree(root.right);
                root.right = invertTree(temp);

                return root;


            }
        }
        public TreeNode invertTree(TreeNode root) {
            //exit of the recursion
            if(root == null) return root;//=null

            //swap the children
            // swapChildren(root);
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);

            return root;
        }

        // public void swapChildren(TreeNode root){
        //在之前已经判断了root ！= null 所有不会报错 root.left 是可以是null的
        //     TreeNode temp = root.left;
        //     root.left = root.right;
        //     root.right = temp;

        // }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = root.left;//先保留左边的值
        root.left = invertTree(root.right);//改变左边的值
        root.right = invertTree(left);//将之前保留的值放到右边去
        ////不能直接root.right = invertTree(root.left);因为root.left已经改成right了
        return root;
    }
}
