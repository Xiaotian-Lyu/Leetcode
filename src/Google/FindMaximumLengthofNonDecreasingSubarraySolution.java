package Google;

public class FindMaximumLengthofNonDecreasingSubarraySolution {
    public int findMaximumLengthOfNonDecreasingSubarray1(int[] arr) {
        /**
         * Input:  arr = [0, 7, 3, 10, 2, 4, 6, 8, 0, 9, -20, 4]
         * Output: 4
         * Explanation：
         * The maximum length of non-decreasing subarray is 4, which corresponds to the subarray [2, 4, 6, 8].
         *
         * //满足条件的最小窗口
         * int left = 0;
         * int sum = 0;
         * int res = 0;
         * for(int right = 0; right < array.length; right++){//
         *   	sum += array[right];
         *   	while(sum > target){//满足条件--缩小窗口
         *       	res = Math.min(res, right - left + 1);
         *       	left++;
         *     }
         *   	//res = Math.min(res, right - left + 1);
         * }
         *
         * //满足条件的最大窗口
         * int left = 0;
         * int sum = 0;
         * int res = 0;
         * for(int right = 0; right < array.length; right++){//
         *   	sum += array[right];
         *   	while(sum > target){//不满足条件--缩小窗口
         *       	//res = Math.min(res, right - left + 1);
         *       	left++;
         *     }
         *   	//满足条件
         *   	res = Math.max(res, right - left + 1);
         * }
         */

        // write your code here
        int left = 0;
        int res = 0;
        for(int right = 0; right < arr.length; right++){
            while(!helper(arr, left, right)){//not  Non-Decreasing -> move left 这里的时间复杂度是On2
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public int findMaximumLengthOfNonDecreasingSubarray2(int[] arr) {
        // write your code here
        //更简单的方式
        int left = 0;
        int res = 0;
        for(int right = 0; right < arr.length; right++){
            if(right > 0 && arr[right] < arr[right - 1]){//not compare with left
                //一旦遇到递减 就从头开始 所以更新left
                left = right;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public int findMaximumLengthOfNonDecreasingSubarray3(int[] arr) {
        // write your code here
        int left = 0;
        int res = 0;
        int length = 0;
        for(int right = 0; right < arr.length; right++){
//            int length = 0; 一直被重置
            while(right > 0 && left < right && arr[right] < arr[right - 1]){//not compare with left
                length--;
                left++;
            }
            length++;
            res = Math.max(res, length);
        }
        return res;
    }

    public boolean helper(int[] arr, int left, int right){
        for(int i = left; i <= right; i++){
            if(i + 1 <= right && arr[i] > arr[i + 1]){
                return false;
            }
        }
        return true;//Non-Decreasing
    }

    public static void main(String[] args){
        FindMaximumLengthofNonDecreasingSubarraySolution test = new FindMaximumLengthofNonDecreasingSubarraySolution();
        int[] n1 = {0, 7, 3, 10, 2, 4, 6, 8, 0, 9, -20, 4};
        int[] n2 = {5, 4, 3, 2, 1};
        System.out.println(test.findMaximumLengthOfNonDecreasingSubarray1(n1));
        System.out.println(test.findMaximumLengthOfNonDecreasingSubarray2(n1));
        System.out.println(test.findMaximumLengthOfNonDecreasingSubarray3(n1));

        System.out.println(test.findMaximumLengthOfNonDecreasingSubarray1(n2));
        System.out.println(test.findMaximumLengthOfNonDecreasingSubarray2(n2));
        System.out.println(test.findMaximumLengthOfNonDecreasingSubarray3(n2));
    }
}
