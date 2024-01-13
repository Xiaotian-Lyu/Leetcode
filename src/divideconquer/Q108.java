package divideconquer;

public class Q108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    private TreeNode helper(int[] nums, int l, int r){//不是Treenode. private 更好
        //the condition of out of recursion
        if(l > r) return null;

        //find the mid of nums
        int m = (r-l)/2 + l;//除法+int 自动取整
        TreeNode root = new TreeNode(nums[m]);
        root.left = helper(nums,l,m-1);//需要赋值 root.left，左边不是0 而是l
        root.right = helper(nums,m+1,r);//不是nums.length-1而是r
        return root;
    }

}
