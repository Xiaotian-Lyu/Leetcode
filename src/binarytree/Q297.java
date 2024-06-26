package binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q297 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            DFS(root, builder);
            return builder.toString();
        }
        public void DFS(TreeNode root, StringBuilder builder){
            //exit of the recursion
            if(root == null){
                builder.append("null,");
                return;
            }
            //root
            builder.append(root.val).append(",");

            //left
            DFS(root.left, builder);

            //right
            DFS(root.right, builder);

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            //错误写法：Queue<Integer> queue
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return helper(queue);
        }
        public TreeNode helper(Queue<String> queue){//DFS
            if(queue.isEmpty()) return null;
            String poll = queue.poll();
            if(poll.equals("null")) return null;

            //root
            TreeNode root = new TreeNode(Integer.parseInt(poll));

            //left
            root.left = helper(queue);//因为queue 不断poll 出来所以不需要更新argument

            //right
            root.right = helper(queue);//因为queue 不断poll 出来所以不需要更新argument

            return root;
        }

    }
}
