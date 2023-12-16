package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Q46_1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); // 最后的返回值
        helper(res, nums, 0); // 回溯的方法
        helper1(res, new ArrayList<Integer>(), nums, new boolean[nums.length]); // 回溯的方法
        return res;
    }

    private void helper1(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            helper1(res, list, nums, visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }

    private void helper(List<List<Integer>> res, int[] nums, int firstIndex) {
        // 递归的出口，到最后一个index了，就把nums的排序加入res中
        if (firstIndex == nums.length - 1) {
            // 新建一个list，保存当前nums的排序，并且加入到res中
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }
        // 把从firstIndex开始的每个数和firstIndex交换
        // 交换后，进入下一层，firstIndex++
        // 在上一层返回之后，需要backtrack这一层做的操作，也就是交换回来，这一步回滚的操作，就是backtrack回溯和recursion递归的区别
        for (int i = firstIndex; i < nums.length; i++) {
            swap(nums, firstIndex, i);
            helper(res, nums, firstIndex + 1);
            swap(nums, firstIndex, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int n = nums[i];
        nums[i] = nums[j];
        nums[j] = n;
    }


}
