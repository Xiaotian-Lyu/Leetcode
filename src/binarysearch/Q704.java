package binarysearch;

public class Q704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    class Solution {
        public int search(int[] nums, int target) {
            int left = 0,right = nums.length;

            while(left < right){
                int mid = left + (right - left)/2;
                if(nums[mid] == target){
                    return mid;
                }else if(nums[mid] < target){
                    left = mid + 1;
                }else if(nums[mid] > target){
                    right = mid;
                }
            }

            return -1;

        }
    }
}
