package Google;

public class FindContiguousSubarray {
    public int findContiguousSubarrayWithLargestMinPlusMax(int[] nums) {
        // write your code here
        // sliding window more like sliding window
        // int left = 0;
        // int maxSum = -1;
        // for(int right = 1; right < nums.length; right++){//计算所有可能的
        //   int min = findMin(left, right, nums);
        //   int max = findMax(left, right, nums);
        //   int sum = min + max;
        //   if(sum < maxSum){
        //     left++;
        //   }
        //   maxSum = Math.max(min + max);
        // }
        int maxSum = -1;
        for(int left = 0; left < nums.length - 1; left++){
            //begin
            int min = nums[left];
            int max = nums[left];
            for(int right = left + 1; right < nums.length; right++){// left + 1
                min = Math.min(min, nums[right]);//update min
                max = Math.max(max, nums[right]);//update max

                maxSum = Math.max(maxSum, min + max);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        FindContiguousSubarray test1 = new FindContiguousSubarray();
        int[] nums = {4, 6, 2, 8, 10};
        System.out.println(test1.findContiguousSubarrayWithLargestMinPlusMax(nums));  // 输出应为18

        FindContiguousSubarray test2 = new FindContiguousSubarray();
        int[] nums1 = {6, 2, 9, 1, 7};
        System.out.println(test2.findContiguousSubarrayWithLargestMinPlusMax(nums1));  // 输出应为11
    }
}
