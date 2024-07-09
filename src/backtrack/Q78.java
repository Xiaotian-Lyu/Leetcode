package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Q78 {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            //create a function to do the recursion
            backtracking(nums, new ArrayList<>(), 0);
            return result;
        }

        public void backtracking(int[] nums, List<Integer> path, int index){
            //excit of the recursion - finish all the path
            result.add(new ArrayList<>(path));

            //recursion
            for(int i = index; i < nums.length; i++){//Given an integer array nums of unique elements 所以nums.length
                path.add(nums[i]);
                backtracking(nums, path, i + 1);
                path.remove(path.size() - 1);//path.remove(path.length - 1);
            }

            return;

        }
    }
}
