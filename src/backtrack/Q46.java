package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Q46 {
    public class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(nums, 0, result);
            return result;
        }

        private void backtrack(int[] nums, int start, List<List<Integer>> result) {
            if (start == nums.length) {
                List<Integer> current = new ArrayList<>();
                //这一段就是python里的浅保存
                for (int num : nums) {
                    current.add(num);
                }

                result.add(current);
                return;
            }
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                backtrack(nums, start + 1, result);
                swap(nums, start, i);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


}
