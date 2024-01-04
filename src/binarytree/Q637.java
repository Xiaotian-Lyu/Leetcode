package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();//a list of result
        Queue<TreeNode> queue = new LinkedList<>();//a queue of treeNode

        if(root == null) return result;
        queue.offer(root);//add the root into the queue
        while (!queue.isEmpty()){
            int size = queue.size();//get the number of each level of TreeNode
            Double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();//get each TreeNode of each level
                sum += node.val;//plus all the value of each level
                if(node.left != null) queue.offer(node.left);//可以不用 root = node.left root 就不要变了
                if(node.right != null) queue.offer(node.right);
            }
            result.add(sum/size);
        }

        return result;
    }
}
