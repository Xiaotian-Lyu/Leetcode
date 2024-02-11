package binarytree;

import java.util.ArrayList;
import java.util.List;

public class Q199 {
    //深度优先遍历
    public List<Integer> rightSideView(TreeNode root) {
        //each layer have only one node to be seen
        List<Integer> res = new ArrayList<>();
        //if(root == null) return res;
        help(res,root,0);
        return res;//错误写法return help(res,root,0);
    }

    private void help(List<Integer> res,TreeNode root,int level){
        //exit of the recursion
        if(root == null) return;//错误写法if(root == null) return res;

        //check and add
        if(res.size() == level){
            res.add(root.val);
        }

        help(res,root.right,level+1);
        help(res,root.left,level+1);

    }

}
