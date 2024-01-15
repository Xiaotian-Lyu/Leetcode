package binarysearch;

public class allKindsOfSolution {
    //find the target
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
        }
        return -1;//不是left 因为上面第10行找到了target 就返回了需要的值 出了while循环后 都找不到说明不存在！！！
    }

    //find the left side of target （符合条件的最小值）
    /**
     * 还有另外一种算法 看第69题
     */
    public int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;//开区间
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) right = mid;//这一行可以合并
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid;//这一行可以合并
        }
        return left;
        /*
        最后判断一下left是否越界？
        if (left < 0 || left >= nums.length) return -1;
        return nums[left] == target ? left : -1;
        */
    }

    //find the right side of target（符合条件的最大值）
    public int right_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;//开区间
        while (left < right) {//没有等于号
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) left = mid + 1;//这行可以合并
            if (nums[mid] < target) left = mid + 1;//这行可以合并
            if (nums[mid] > target) right = mid;
        }
        return left - 1;//left = mid + 1  mid就是要找的值
    }


}
