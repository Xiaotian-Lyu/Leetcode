package binarytree;

public class Q543 {
    class Solution {
        int result = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            DFS(root);//这一步 就是递归找每个node 的height：但是例1- root1 的左高度 算是2 右高度算是 1 根据题目意思 来调整
            return result;
        }

        //DFS - postorder - return the longest path of one side
        //get the height of each root
        public int DFS(TreeNode root){
            if(root == null) return 0;

            //left
            int left = DFS(root.left);

            //right
            int right = DFS(root.right);

            //root
            result = Math.max(result, left + right);
            //这一步 是真正找diameter 在这个过程中 不断更替；不需要 + root自己，例1- root1 的左高度 算是2 右高度算是 1 根据题目意思 来调整

            return Math.max(left, right) + 1;//需要 + root自己，+ 1来增加每一层的高度
        }


    }
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
