package binarysearch;

public class Q153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length -1;

        //while left == right (find the value)===> return the left
        while(left < right){

            int mid = left + (right-left)/2; //in case to overflow
            if(nums[mid] < nums[right]){
                right = mid;
            }else{
                //nums[right] > nums[mid]
                //nums[mid] = nums[right] not happen
                left = mid + 1;
            }
        }

        return nums[left];
    }
}
