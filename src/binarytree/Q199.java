package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199 {
    /**
     * 这种写法逻辑更简单
     */
    class Solution2 {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        public List<Integer> rightSideView(TreeNode root) {
            if(root == null) return result;

            queue.add(root);

            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size ;i++){
                    TreeNode poll = queue.poll();
                    if(i == size - 1){//check if it the last node of this level
                        result.add(poll.val);
                    }
                    //chekc the next level nodes
                    if(poll.left != null) queue.add(poll.left);
                    if(poll.right != null) queue.add(poll.right);
                }
            }

            return result;

        }
    }
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
