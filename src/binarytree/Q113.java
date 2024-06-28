package binarytree;

import java.util.ArrayList;
import java.util.List;

public class Q113 {
    class Solution3 {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<Integer> path =  new ArrayList<>();
            DFS(root, targetSum, path);
            return result;
        }
        //DFS preoreder - root left right
        public void DFS(TreeNode root, int targetSum, List<Integer> path){
            if(root == null) return;
            //exit of the recursion
            if(root.left == null && root.right == null){//reach to the leaf node
                path.add(root.val);//add to the path
                if(root.val == targetSum){//check the root.val
                    result.add(new ArrayList<>(path));
                }

                // return; 也可以在这里return 但是return之前要 把path上刚加的 node remove掉再return
                // 实际上44 45 行已经写了这个操作了
            }else{
                //not reach to the leaf node 就继续往左走往右走
                path.add(root.val);
                DFS(root.left, targetSum - root.val, path);
                DFS(root.right, targetSum - root.val, path);
                //这里没有到叶子结点是不会backtracking的 只有到了叶子结点之后 才会执行44，45
            }

            //backtracking
            path.remove(path.size() - 1);
            return;//这里的return 可加可不加 因为没有执行 语句了 就自动return了
        }
    }
    /**
     * 不断更替target value 并 backtracking
     */
    class Solution2 {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<Integer> path =  new ArrayList<>();
            DFS(root, targetSum, path);
            return result;
        }
        //DFS - pre - order
        public void DFS(TreeNode root, int targetSum, List<Integer> path){ //path 是引用变量 只有一个值 需要 backtracking
            //exit of the recursion
            if(root == null) return;
            if(root.left == null && root.right == null && root.val == targetSum){
                path.add(root.val);//不能漏
                //错误写法：result.add(path);
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1); //不能漏 可以和最后一行合并 那就要把下面的内容写到else 里面去
                return;
            }
            path.add(root.val);
            //left
            DFS(root.left, targetSum - root.val, path);

            //right
            DFS(root.right, targetSum - root.val, path);

            //backtracking
            //错误写法：path.setLength(path.size() - 1);//setLength 方法通常用于字符串操作，特别是在 Java 中的 StringBuilder 类中
            path.remove(path.size() - 1);
            return;

        }

    }
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
