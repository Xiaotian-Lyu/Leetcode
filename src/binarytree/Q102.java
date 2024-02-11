package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        //queue feature: first in fist out
        Queue<TreeNode> queue = new LinkedList<>();//错误写法：Queue<Integer> queue = new Queue<>()

        if(root == null) return res;

        //push the root - first layer
        queue.add(root);//错误写法：queue.push(root);

        while(!queue.isEmpty()){//错误写法：!queue.isEmpty
            int size = queue.size();//how much times poll
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < size;i++){
                TreeNode node = queue.poll();//错误写法：queue.pop()
                list.add(node.val);

                //check the left side and right side
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
