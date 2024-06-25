package binarytree;

import java.util.ArrayList;
import java.util.List;

public class Q113 {
    /**
     * 方法一：从root 往下加值
     */
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            int sum = 0;
            List<Integer> path = new ArrayList<>();
            DFS(root,targetSum,sum,path);
            return result;
        }

        //DFS
        public void DFS(TreeNode root, int targetSum, int sum, List<Integer> path){
            if(root == null) return;
            //exit of the recursion
            if(root.left == null && root.right == null){
                sum += root.val;
                path.add(root.val);
                //check the sum of one path
                if(sum == targetSum){
                    result.add(new ArrayList<>(path));
                }
                path.remove(path.size() - 1);
                return;
            }

            path.add(root.val);//list 的返回值是boolean
            //left
            DFS(root.left, targetSum, sum + root.val, path);
            //right
            DFS(root.right, targetSum, sum + root.val, path);
            path.remove(path.size() - 1);

        }
    }
}
