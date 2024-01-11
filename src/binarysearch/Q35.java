package binarysearch;

public class Q35 {
    //find the minimum value that satisfied the condition
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;//右边开区间
        while (left < right) {//没有=号 因为[left,left)中间没有值
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {//直接写else？
                // 为什么 = 的时候 不return？即使相等 但不一定是我们要找的值 还要向左找
                right = mid;
            }
        }
        return left;

    }

}
