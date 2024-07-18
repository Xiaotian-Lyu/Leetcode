package arraryandstring;

public class Q75 {
    class Solution {
        public void sortColors(int[] nums) {
            int left = 0, right = nums.length - 1, i = 0;

            while(i <= right){
                if(nums[i] == 0){
                    // i = 0
                    swap(nums, i, left);
                    i++;
                    left++;
                }else if(nums[i] == 2){
                    // i = 2
                    swap(nums, i, right);
                    right--;
                }else{
                    // i = 1
                    i++;
                }
            }
        }

        public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
