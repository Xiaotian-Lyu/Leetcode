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

    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            /**
             * 找左边界主要区别：
             * 1.right 的的取值 是开区间还是闭区间
             * 2.
             * while 条件（当right 是开区间的时候 while条件没有等号 ==> 当left = right 的时候出循环）
             * 当right 是闭区间的时候 while条件有等号 ==> 当left = right的时候还能进行比较 ==> 当left = right + 1 出循环
             *
             * 3.收缩左边界的时候不变因为左边界一直是闭区间
             * 收缩右区间的时候要mid-1,因为改成闭区间后右边区间的值已经比较过了，所以要-1
             */

            while(left <= right){
                int mid = left + (right - left)/2;
                if(nums[mid] < target){
                    left = mid + 1;
                }else if(nums[mid] > target){ //只有else 后面不能加（）
                    right = mid - 1;
                }else if(nums[mid] == target){ //如果有相同的数字就不能直接返回 而是要向左移动
                    return mid;
                }
            }

            return left;
        }

    }

}
