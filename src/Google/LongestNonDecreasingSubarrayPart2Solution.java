package Google;

public class LongestNonDecreasingSubarrayPart2Solution {
    public int longestNonDecreasingSubarray1(int[] nums) {
        // write your code here
        /**
         * You can choose any one index and change its value to any number that you like.
         * What will be the longest non decreasing subarray now:
         * In the same example as before, the answer would now be:
         * ans = 6, [2 4 6 8 0 9], by changing 0 -> 8 so the subarray becomes non-decreasing.
         * Example 1:
         * Input:  nums = [2, 4, 6, 8, 0, 9]
         * Output: 6
         * Explanation:
         * By changing the value at index 4 from 0 to 8,
         * the array becomes [2, 4, 6, 8, 8, 9], which is non-decreasing.
         * The length of this subarray is 6, which is the longest possible non-decreasing
         * subarray after making one change.
         */
        int left = 0;
        int res = 0;
        for(int right = 0; right < nums.length; right++){
            while(!helper(nums, left, right)){//not  Non-Decreasing -> move left 用两个循环时间复杂度是On2
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
//方法二三都不对因为count 变成只能改一次 而不是每一段都有一次 GoldenArray 情况类似
//    public int longestNonDecreasingSubarray2(int[] nums){
//        int res = 0;
//        int left = 0;
//        int count = 0;//change
//        for(int right = 0; right < nums.length; right++){
//            if(count == 0 && right > 0 && right < nums.length - 1 && nums[right] < nums[right - 1]){//not Non-de
//                //dont need to update
//                count++;
//                if(right > 0 && nums[right] >= nums[right - 1]){
//                    right++;
//                }
////                //5.4.3.2.1
////                System.out.println("count: " + count);
////                System.out.println("right: " + right);
//            }else if(count > 0 && right > 0 && nums[right] < nums[right - 1]){
//                //update the left
//                left = right;
//            }
//            res = Math.max(res, right - left + 1);
//        }
//        return res;
//    }
//
//    public int longestNonDecreasingSubarray3(int[] nums){
//        int res = 0;
//        int left = 0;
//        int count = 0;//change
//        for(int right = 0; right < nums.length; right++){
//            if(right > 0 && right < nums.length - 1 && nums[right] < nums[right - 1]){
//                if(count == 0){
//                    count++;//这里的right++直接合并到for 循环里
//                }else {
//                    left = right;
//                }
//            }
//            res = Math.max(res, right - left + 1);
//        }
//        return res;
//    }

    public boolean helper(int[] arr, int left, int right){
        int count = 0;
        for(int i = left; i <= right; i++){
//            if(count == 0 && i + 1 <= right && arr[i] > arr[i + 1]){//两者都可以- 只要确保不越界
//                count += 1;//change one number
//            }else if(count > 0 && i + 1 <= right && arr[i] > arr[i + 1]){
//                return false;
//            }
              if(count == 0 && i > left && arr[i] < arr[i - 1]){//两者都可以- 只要确保不越界
                  count += 1;
              } else if (count == 1 && i > left && arr[i] < arr[i - 1]) {
                  return false;
              }
        }
        return true;//Non-Decreasing
    }
//
//    public int longestSubarray(int[] nums){
//        int left = 0;
//        int change = 0;
//        int res = 0;
//        for(int right = 0; right < nums.length; right++){
//            if(right > 0 && nums[right] < nums[right - 1]){
//                //not leagal
//                if(change == 0){
//                    change += 1;
//                }else{
//                    //change = 1
//                    while (nums[right] < nums[right - 1] && left < right) {
//                        left++;
//                    }
//                    left = right;//restart
//                    change = 0;//reset
//                }
//            }
//            res = Math.max(res, right - left + 1);
//        }
//        return res;
//    }


//    public int longestSubarray2(int[] nums) {
//        int left = 0; // 窗口左边界
//        int change = 0; // 是否已经使用了一次修改
//        int res = 0; // 结果：最长非递减子数组长度
//
//        for (int right = 0; right < nums.length; right++) {
//            if (right > 0 && nums[right] < nums[right - 1]) {
//                if (change == 0) {
//                    // 如果未修改过，允许修改
//                    change = 1;
//                } else {
//                    // 如果已经修改过，缩小窗口，直到合法
//                    while (nums[right] < nums[right - 1] && left < right) {
//                        left++;
//                    }
//                    change = 0; // 重置修改机会
//                }
//            }
//            // 更新结果
//            res = Math.max(res, right - left + 1);
//        }
//        return res;
//    }



    public static void main(String[] args) {
        LongestNonDecreasingSubarrayPart2Solution test = new LongestNonDecreasingSubarrayPart2Solution();
        int[] nums = new int[]{2, 4, 6, 8, 0, 9};
        int[] nums1 = new int[]{5, 4, 3, 2, 1};
        int[] nums2 = new int[]{2, 1, 3, 4, 1, 5, 6, 7, 8, 9};

        System.out.println(test.longestNonDecreasingSubarray1(nums));
//        System.out.println(test.longestSubarray(nums));
//        System.out.println(test.longestNonDecreasingSubarray2(nums));
//        System.out.println(test.longestNonDecreasingSubarray3(nums));

        System.out.println(test.longestNonDecreasingSubarray1(nums1));
//        System.out.println(test.longestSubarray(nums1));
//        System.out.println(test.longestSubarray2(nums1));

//        System.out.println(test.longestNonDecreasingSubarray2(nums1));
//        System.out.println(test.longestNonDecreasingSubarray3(nums1));

        System.out.println(test.longestNonDecreasingSubarray1(nums2));
//        System.out.println(test.longestSubarray(nums2));
//        System.out.println(test.longestSubarray2(nums2));

//        System.out.println(test.longestNonDecreasingSubarray2(nums2));
//        System.out.println(test.longestNonDecreasingSubarray3(nums2));
    }
}
