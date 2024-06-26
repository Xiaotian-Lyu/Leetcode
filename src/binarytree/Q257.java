package binarytree;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
    /**
     *涉及到String 的拼接的尽量用StringBuilder
     * 解决方案 1 中字符串拼接的高时间复杂度主要是由于每次拼接操作都会创建新的字符串对象。
     * 解决方案 2 使用 StringBuilder 更加高效，避免了频繁创建新字符串，具有更好的性能和更低的时间复杂度。
     */
    class Solution2 {
        List<String> result = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            DFS(root, builder);
            return result;
        }
        public void DFS(TreeNode root , StringBuilder builder){
            //pre order
            //exit of the recursion
            if(root == null) return;

            int length = builder.length();

            //reach to the leaf
            if(root.left == null && root.right == null){
                builder.append(root.val);//到叶子结点就不需要 append("->");
                result.add(builder.toString());

            }else{
                builder.append(root.val);//没有到叶子结点也要加上去
                builder.append("->");//不是叶子结点就说明 左边或者右边一定有 node 所以一定加
                //left
                if(root.left != null) DFS(root.left, builder);
                //right
                if(root.right != null) DFS(root.right, builder);
            }

            //backtracking
            builder.setLength(length);

        }
    }

    /**
     * 这个用string直接add 时间会慢
     */
    class Solution1 {
        List<String> result = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            helper(root, "");
            return result;
        }

        public void helper(TreeNode root, String path){//这里的path 就是和sum 一样 求每条路径的和 从根节点开始向下recursion 把sum 一路传递下去
            if(root == null) return;
            if(root.left == null && root.right == null){
                result.add(path + root.val);
            }

            //left
            if(root.left != null){
                helper(root.left, path + root.val + "->");//通过参数的传递把根节点自己 写上去 并且传递下去
            }

            //right
            if(root.right != null){
                helper(root.right, path + root.val + "->");
            }

        }
    }
}
