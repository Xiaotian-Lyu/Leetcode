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
        int left = 0, right = arr.length - 1; // mid = left + 1 = arr.length??, left = right = arr.length - 1
        // left == right
        // right的最大值是arr.length-1, left最大值也是arr.length - 1
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) right = mid;
            else left = mid + 1;
        }
        //肯定存在peak 因为 left 一直往右边移动说明 最右边的就是 peak
        //就可以直接返回right 的值 = arr.length - 1
        return left;
    }
}
