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

        public void helper(TreeNode root, String path){
            if(root == null) return;
            if(root.left == null && root.right == null){
                result.add(path + root.val);
            }

            //left
            if(root.left != null){
                helper(root.left, path + root.val + "->");
            }

            //right
            if(root.right != null){
                helper(root.right, path + root.val + "->");
            }

        }
    }
}
