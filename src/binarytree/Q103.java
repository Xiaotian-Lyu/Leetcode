package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q103 {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            boolean zigzag = false;// do the zigzag

            //root null
            if(root == null) return result;

            //add root to queue
            queue.add(root);

            //keep poll form the queue
            while(!queue.isEmpty()){
                //check queue size for each level
                int size = queue.size();
                LinkedList<Integer> eachLevelNodes = new LinkedList<>();

                for(int i = 0; i < size ; i++){
                    TreeNode node = queue.poll();

                    //check the next level add to queue
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);

                    //check the status of zigzag add to eachLevelNodes
                    if(zigzag){ //true - add first to list - zigzag
                        eachLevelNodes.addFirst(node.val);
                    }else{//false - add last to list - normal
                        eachLevelNodes.add(node.val);
                    }
                }
                //each level end add to result
                result.add(eachLevelNodes);

                //change the status of zigzag
                //错误写法：zigzag = - zigzag;
                zigzag = !zigzag;
            }

            return result;

        }
    }
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
