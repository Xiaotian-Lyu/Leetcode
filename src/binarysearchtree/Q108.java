package binarysearchtree;

public class Q108 {
    class Solution2 {
        public TreeNode sortedArrayToBST(int[] nums) {
            int left = 0, right = nums.length - 1;
            return helper(nums, left, right);
        }

        //keep find the mid of array to create the root - pre order
        public TreeNode helper(int[] nums, int left, int right){
            //exit of the recursion 注意这里的出recursion的条件
            if(nums == null) return null;
            if(left > right) return null;

            //root
            int mid = left + (right - left)/2;
            TreeNode root = new TreeNode(nums[mid]);

            //left
            root.left = helper(nums, left, mid - 1);

            //right
            root.right = helper(nums, mid + 1, right);

            return root;//不要忘
        }
    }
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            return helper(nums, left, right);
        }

        public TreeNode helper(int[] nums, int leftIndex, int rightIndex){
            //exit of the recusion
            if(leftIndex > rightIndex) return null;//这里没办法return root

            //keep find the central - root
            //recursion - pre order
            int mid = leftIndex+ (rightIndex - leftIndex) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, leftIndex, mid - 1);
            root.right = helper(nums, mid + 1, rightIndex);

            return root;

        }
    }
}
