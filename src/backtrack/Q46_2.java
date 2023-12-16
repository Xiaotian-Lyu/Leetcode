package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Q46_2 {
    public List<List<Integer>> permute(int[] nums) {//输入一个定长的数组
        //ArrayList<Integer> res = new ArrayList<>();???
        List<List<Integer>> res = new ArrayList<>();//最后的返回值
        help(res, nums, 0);//初始值nums,firstIndex,
        return res;
    }

    private void help(List<List<Integer>> res, int[] nums, int firstIndex) {
        if (firstIndex == nums.length - 1) {
            List<Integer> finalList = new ArrayList<>();
            for (int num : nums) {
                finalList.add(num);
            }
            res.add(finalList);
            return;
        }
        for (int i = firstIndex; i < nums.length; i++) {
            swap(nums, firstIndex, i);
            help(res,nums,firstIndex+1);
            swap(nums, i, firstIndex);
        }

    }
    private void swap ( int[] nums, int i, int j){
        int n = nums[i];
        nums[i] = nums[j];
        nums[j] = n;
    }
}
