package binarysearch;

public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        //find the minIndex of target
        //find the minIndex of (target+1)-1
        int leftIndex = finsMinIndex(nums,target);
        int rightIndex = finsMinIndex(nums,target+1)-1;

        //[-1,-1]
        if(leftIndex == nums.length || nums[leftIndex] != target){
            return new int[]{-1,-1};//错误写法int[-1,-1];
        }

        return new int[]{leftIndex,rightIndex};

    }

    //find the minIndex - binary search
    public int finsMinIndex(int[] nums,int target){
        int left = 0;
        int right = nums.length;

        while(left < right){
            int mid = left + (right -left)/2; //in case not to overflow

            if(nums[mid] < target){
                left = mid + 1;
            }else{
                //target <= nums[mid]
                right = mid;
            }
        }
        return left;
    }
}
