package binarytree;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
    class Solution {
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
