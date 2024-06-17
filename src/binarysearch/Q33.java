package binarysearch;

public class Q33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            //three condition:
            if(nums[mid] == target) return mid;

            //最好判断mid 和 right的关系因为 mid = right 只有一种情况就是 到达右边边界
            /**
             * 第一种：mid == target 返回
             *
             * **分段处理**
             *
             * 第二种：右边段有序，判断条件：mid <  right 注意⚠️：
             *
             * 建议右边界 进行比较 左边界会有例外情况
             *
             * 左边界 有可能会=mid 右边界不会 mid在做除法运算会向左取整
             *
             * 判断一下target 是否在这个 右边区间，改动left/ 否则改right
             *
             * 第三种：左边段有序，判断条件：left <= mid（else）
             *
             * 判断一下target 是否在这个 左边区间，改动right/ 否则改left
             */
            if(nums[mid] < nums[right]){
                //nums[mid] <= nums[mid]
                //rightside is ascending
                if(nums[mid] < target && target <= nums[right]){
                    //target is in the rightside
                    left = mid + 1;
                }else{
                    right = mid -1;
                }


            }else{
                //left side is ascending
                if(nums[left] <= target && target < nums[mid]){// 关于"=" target = mid 已经判断过了
                    //target is in the leftside
                    right = mid -1;
                }else{
                    left = mid + 1;
                }

            }
        }

        return -1;
    }
}
