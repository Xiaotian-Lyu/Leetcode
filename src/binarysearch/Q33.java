package binarysearch;

public class Q33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            //three condition:
            if(nums[mid] == target) return mid;

            //最好判断mid 和 right的关系因为 mid = right 只有一种情况就是 到达右边边界
            //好像是bug 两种这情况 都可以 nums[mid] <= nums[right]
            //nums[left] <= nums[mid]   因为mid 取数需要用到/，在除不尽的这种情况下 会取整到左边的值 会有误区
            if(nums[mid] < nums[right]){
                //nums[mid] <= nums[mid]
                //rightside is ascending
                if(nums[mid] < target && target <= nums[right]){
                    //target is in the rightside
                    left = mid + 1;
                }else{
                    right = mid -1;
                }


            }else{
                //left side is ascending
                if(nums[left] <= target && target < nums[mid]){// 关于"=" target = mid 已经判断过了
                    //target is in the leftside
                    right = mid -1;
                }else{
                    left = mid + 1;
                }

            }
        }

        return -1;
    }
}
