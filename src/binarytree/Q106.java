package binarytree;

import java.util.HashMap;
import java.util.Map;

public class Q106 {
    Map<Integer,Integer> map = new HashMap<>();
    int indexPostorder ;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        indexPostorder = postorder.length - 1;

        //need a hashmap to store the indexes of inorder values
        //store inorder ---- the root seperate the leftTree and rightTree
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }

        return helper(postorder,0,postorder.length - 1);
    }

    // postorder--- find the root
    public TreeNode helper(int[] postorder,int left ,int right){
        //the recursion exit
        if(left > right) return null;

        int rootVal = postorder[indexPostorder--];//find the root val
        int inorderIndex = map.get(rootVal); //find the index of root in inorder

        //new TreeNode of root
        TreeNode root = new TreeNode(rootVal);

        //do the recursion
        // postorder：3-root 20-right 7-left 按照这个顺序
        root.right = helper(postorder,inorderIndex+1 ,right);
        root.left = helper(postorder,left ,inorderIndex-1);

        return root;
    }
}
