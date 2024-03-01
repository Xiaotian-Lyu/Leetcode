package binarysearch;

public class findPeak {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        int target = 10;
//        System.out.println(findMinIndexLargerThanTarget(arr, target));

        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(findPeak(arr));
    }

    static int findMinIndexLargerThanTarget(int[] arr, int target) {
        int left = 0, right = arr.length;
        // left == right
        // right的最大值是arr.length-1, left最大值也是arr.length - 1
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) right = mid;
            else left = mid + 1;
        }
        //有可能是找不到比target 大的值的 所以最后要判断一下
        //left = right 这个时候是临界点 这个时候 left = mid + 1 = right + 1 = left + 1 = arr.length
        //这个时候left > right 出循环 没找到 这个值
        return left == arr.length ? -1 : left;
    }

    static int findPeak(int[] arr) {
        int left = 0, right = arr.length - 1;
        /**
         * 1。peak肯定存在：如果一直往左走或者一直往右走 则return 0 或者 arr.length - 1
         * 2。nums[mid] = nums[mid + 1] 中等号无所谓 可以加到任何一边 也可以不加
         * 3。left == right 的时候 就是peak 直接return 就行
         */
        while (left < right) {
            int mid = left + (right - left) / 2;
            if( arr[mid] < arr[mid + 1]){
                left = mid + 1;
            }else if( arr[mid] > arr[mid + 1]){
                right = mid;
            }
        }

        return left;
    }
}
