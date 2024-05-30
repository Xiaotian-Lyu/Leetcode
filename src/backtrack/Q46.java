package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Q46 {
    public class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backtrack(nums, res, 0);
            return res;
        }

        private void backtrack(int[] nums, List<List<Integer>> res, int start) {
            //exit of the recursion
            if (start == nums.length) {//错误写法：cur.length()
                List<Integer> cur = new ArrayList<>();
                for (int num : nums) {
                    cur.add(num);
                }
                res.add(cur);
                return;//别忘了
            }

            for (int i = start; i < nums.length; i++) {
                swap(i, start, nums);
                //错误写法：backtrack(nums, res, start + 1, cur);
                backtrack(nums, res, start + 1);
                swap(i, start, nums);
            }

        }

        private void swap(int i, int start, int[] nums) {
            int temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;
        }
    }
    /**
     * python 解法：
     * class Solution(object):
     *     def permute(self, nums):
     *         """
     *         :type nums: List[int]
     *         :rtype: List[List[int]]
     *         """
     *         res = []
     *
     *         def backtrack(start):
     *             # exit of the recursion
     *             if start == len(nums):
     *                 res.append(nums[:])
     *                 return
     *             for i in range(start, len(nums)):
     *                 nums[start], nums[i] =  nums[i] ,nums[start]  #swap
     *                 backtrack(start + 1)
     *                 nums[start], nums[i] =  nums[i] ,nums[start]  #swap back
     *
     *         backtrack(0) #不能忘记
     *         return res
     *
     *
     * """
     * 时间复杂度
     * 对于一个包含 𝑛 个元素的列表，总共有 𝑛!种排列，每种排列都需要
     * 𝑂(𝑛)时间来生成。因而，时间复杂度是 𝑂(n⋅n!)
     * """
     */
}



