package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Q39 {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if(target == 0) return res;
            backtrack(candidates, target, res, new ArrayList<>(), 0);
            return res;
        }


        private void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> cur, int start){
            if(target < 0) return;
            //错误写法：if(target == 0) res.add(cur);
            if(target == 0){
                res.add(new ArrayList(cur));
                return;//别忘记
            }
            //错误写法：i < candidates.length()
            for(int i = start ; i < candidates.length; i++){
                cur.add(candidates[i]);
                //错误写法：不能分开 会修改掉 原始target-上一层的target
                //只需要修改下一层的 target = target - candidates[i];
                //只需要穿参数进去：backtrack(candidates, target, res, cur, i);

                backtrack(candidates, target - candidates[i], res, cur, i);

                cur.remove(cur.size() - 1);

            }
        }

    }
}
