package binarytree;

import java.util.HashMap;
import java.util.Map;

public class Q105 {
    // all the methods will need
    // a hashmap to store the indexes of inorder values
    Map<Integer,Integer> map = new HashMap<>();
    // initial a preIndex ---- to find the root in preorder
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder){
        for(int i = 0; i< preorder.length;i++){//错误写法：i< preorder.length()
            map.put(inorder[i],i);//错误写法：map.add(preorder[i],i)
        }
        return helper(preorder,0,preorder.length-1);//preorder-- find the root
        //错误写法：helper(preorder,preIndex,preorder.length-1)
    }

    public TreeNode helper(int[] preorder,int left ,int right){
        //记得写recursion的出口
        if(left > right) return null;

        //可以合并写 preIndex++;
        int rootVal = preorder[preIndex++];

        //find the index of root in inorder
        int inorderIndex= map.get(rootVal);

        //create a new treeNode
        TreeNode root = new TreeNode(rootVal);

        //preorder: 3-root 9-left 20-right
        root.left = helper(preorder,left,inorderIndex-1);//错误写法直接写left=...
        root.right = helper(preorder,inorderIndex+1,right);

        return root;
    }
}
