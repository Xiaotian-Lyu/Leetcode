package binarytree;

public class Q222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int heightOfLeft = getHeight(root.left);
        int heightOfRight = getHeight(root.right);

        if(heightOfLeft == heightOfRight){
            //in this case left side is complete B-Tree;
            //return 1 << heightOfLeft + countNodes(root.right); ??左移的优先级高于+ 但是没有括号报错
            return (1 << heightOfLeft) + countNodes(root.right);
        }else {
            return (1 << heightOfRight) + countNodes(root.left);
        }

    }

    private int getHeight(TreeNode node){//to get the height of B-tree
//        if (node == null) return 0; do not need to,while node = null height =0;
        int height = 0; //original height 0
        while (node != null){
            height++;
            node = node.left;//only the left side can get the height of B-tree
        }
        return height;
    }

    /**
     * 更简洁的写法
     * class Solution {
     *     int height(TreeNode root) {
     *         return root == null ? -1 : 1 + height(root.left);
     *     }
     *     public int countNodes(TreeNode root) {
     *         int h = height(root);
     *         return h < 0 ? 0 :
     *                height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
     *                                          : (1 << h-1) + countNodes(root.left);
     *     }
     * }
     */
}
