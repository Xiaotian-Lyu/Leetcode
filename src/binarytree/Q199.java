package binarytree;

import java.util.ArrayList;
import java.util.List;

public class Q199 {
    class Solution {
        List<Integer> result = new ArrayList<>();

        public List<Integer> rightSideView(TreeNode root) {
            helper(root,0);
            return result;
        }

        //我需要一个function 可以传递level - root - right - left
        public List<Integer> helper(TreeNode root, int level){
            //遍历顺序root - right - left
            if(root == null) return result;

            //always put right side first
            if(level == result.size()){
                result.add(root.val);
            }

            //right side
            helper(root.right, level + 1);
            helper(root.left,  level + 1);

            return result;
        }
    }
    //深度优先遍历
    public List<Integer> rightSideView(TreeNode root) {
        //each layer have only one node to be seen
        List<Integer> res = new ArrayList<>();
        //if(root == null) return res;
        help(res,root,0);
        return res;//错误写法return help(res,root,0);
    }

    private void help(List<Integer> res,TreeNode root,int level){
        //exit of the recursion
        if(root == null) return;//错误写法if(root == null) return res;

        //check and add
        if(res.size() == level){
            res.add(root.val);
        }

        help(res,root.right,level+1);
        help(res,root.left,level+1);

    }

}
