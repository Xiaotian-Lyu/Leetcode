package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Q22 {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            backtrack(n, res, new StringBuilder(), 0, 0 );
            return res;
        }

        private void backtrack(int n, List<String> res , StringBuilder builder, int left, int right){
            //illegal
            if(right > left) return;

            //exit
            if(left == n && right == n ){
                res.add(builder.toString());
                return;
            }
            if(left < n){
                builder.append("(");
                backtrack(n, res, builder, left + 1, right );
                //错误写法：builder.size()
                builder.setLength(builder.length() - 1);
            }
            if(right < left){
                builder.append(")");
                backtrack(n, res, builder, left, right + 1 );
                builder.setLength(builder.length() - 1);
            }

        }
    }
}
