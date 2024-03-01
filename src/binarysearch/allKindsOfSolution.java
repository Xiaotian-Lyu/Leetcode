package binarysearch;

public class allKindsOfSolution {
    /**
     * find the target
     * @param nums
     * @param target
     * @return
     */
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


    /**
     * 还有另外一种算法 看第69题
     * find the left side of target （符合条件的最小值）
     */
    public int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;//开区间
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) right = mid;// 如果要取左边界 就要把right这个边界更新
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid;//这一行可以合并
        }
        return left;
        /**
        最后判断一下left是否越界？
        if (left < 0 || left >= nums.length) return -1;
        return nums[left] == target ? left : -1;
        */
    }

    /**
     * find the right side of target（符合条件的最大值）
     */
    public int right_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;//开区间
        while (left < right) {//没有等于号
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) left = mid + 1;//如果要取右边界 就不断更新左边的边界
            if (nums[mid] < target) left = mid + 1;//这行可以合并
            if (nums[mid] > target) right = mid;
        }
        return left - 1;//left = mid + 1  mid就是要找的值
        /**
         * 为什么返回left -1;
         * 因为我们对 left 的更新必须是 left = mid + 1，
         * 就是说 while 循环结束时，nums[left] 一定不等于 target 了，
         * 而 nums[left-1] 可能是 target。
         *
         * 1.寻找符合条件的最大值的时候 需要不断更新左边界left = mid + 1;
         * 2.当最后一次mid == target 的时候，还是会更新 left = mid + 1；
         * 3.更新完之后不符合条件了 就不进入while循环 这个时候left = right
         * 4. 1,2,3,4,5,6,6,6,6,7,8,9   left = mid + 1; left = (left + (right -left)/2) + 1
         * 5.left - 1 就是满足条件的最大值
         */
    }


}
