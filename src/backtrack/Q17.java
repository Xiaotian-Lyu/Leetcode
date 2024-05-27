package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    class Solution {
        //array corresbonding - digits and letters
        String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if(digits.length() == 0) return res;
            //错误写法：new Stringbuilder
            help(res, digits, new StringBuilder(), 0);//backtracing;
            return res;
        }

        //backtracing; --- recursion
        private void help(List<String> res, String digits, StringBuilder builder, int index){
            //exit of the recursion
            if( index == digits.length()){
                //错误写法：res = builder.append();
                res.add(builder.toString());
                return;
            }
            char digit = digits.charAt(index);
            //错误写法：letters.[digit - "0"]
            for(char next : letters[digit - '0'].toCharArray()){
                builder.append(next);
                help(res, digits, builder, index + 1);
                //错误写法：builder.getLength
                builder.setLength(builder.length() - 1);
            }
        }
    }
}
