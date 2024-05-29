package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Q77 {
    class Solution {
        /**
         *Time complexity:"n choose k"* k
         *Space complexity: O(k)
         */
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            backtrack(n, k, res, new ArrayList<>(), 1);
            return res;
        }

        private void backtrack(int n, int k, List<List<Integer>> res, List<Integer> cur, int start){
            if(cur.size() == k){
                //错误写法：result.add(new ArrayList<>(current));
                res.add(new ArrayList<>(cur));
                return;
            }

            for(int i = start; i <= n ; i++){
                cur.add(i);
                //错误写法：backtrack(n, k, res, cur, start+1);
                backtrack(n, k, res, cur, i + 1);
                //错误写法：cur.setlength(cur.size - 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

}
