package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //queue feature: first in first out
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        //zigzag(if true traversal): false - addLast / true - addFirst
        boolean zigzag = false;

        if(root == null) return res;
        //add the root - first layer
        queue.add(root);

        while(!queue.isEmpty()){
            //get the size and new list
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            //不能写List<Integer> list = new LikedList<>();因为 List interface里没有addFirst/addLast 方法

            for(int i = 0; i < size;i++){
                TreeNode node = queue.poll();

                //check the zigzag
                if(zigzag){
                    list.addFirst(node.val);
                }else{
                    list.addLast(node.val);
                }


                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }

            }
            res.add(list);
            //change the zigzag
            zigzag = !zigzag;
        }

        return res;

    }
}
