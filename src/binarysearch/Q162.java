package binarysearch;

public class Q162 {
    class Solution {
        public int findPeakElement(int[] nums) {
            int left = 0, right = nums.length - 2;////注意⚠️这里的i < nums.length - 1，i的最大值是i = nums.length - 2
            //为了保证nums[i + 1]不越界

            while(left <= right){
                int mid = left + (right - left)/2;

                if(nums[mid] < nums[mid + 1]){
                    left = mid + 1;
                }else if(nums[mid] > nums[mid + 1]){
                    right = mid - 1;
                }

            }

            return left;
        }
    }
    public int findPeakElement(int[] nums) {
        //binary search to compare mid and mid+1
        //不断缩小左边界 同时不断缩小右边界 直到left = right 这个时候是peak
        //寻找 mid > mid+1 满足条件的最小index
        int left = 0, right = nums.length - 1;//mid + 1 会越界
        /**
         条件 nums[mid] < nums[mid + 1]
         可能会在 mid 是数组最后一个索引时访问越界。
         为了防止这种情况，将二分查找的右边界设置为 nums.length - 1
         而不是 nums.length。
         */

        while(left < right){
            int mid = left+ (right - left)/2;
            if( nums[mid] <= nums[mid + 1]){
                left = mid + 1;
            }else if( nums[mid] > nums[mid + 1]){
                right = mid;//这里满足条件为什么不直接返回mid
            }
        }

        return left;
    }
}

